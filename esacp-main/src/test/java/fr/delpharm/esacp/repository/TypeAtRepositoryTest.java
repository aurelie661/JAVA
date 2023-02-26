package fr.delpharm.esacp.repository;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import fr.delpharm.esacp.domain.TypeAt;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeAtRepositoryTest {
	
	@Autowired
	private TypeAtRepository actionRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	TypeAt type =  new TypeAt((long) 1,"typeAt", true);
	actionRepository.save(type);
	assertNotNull(type);
	Assertions.assertThat(type.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	TypeAt typeAt = actionRepository.findById(1L).get();
	Assertions.assertThat(typeAt.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<TypeAt> actions = actionRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	TypeAt action = actionRepository.findById(1L).get();
	action.setTypeAt("Bruce");
	TypeAt Updated = actionRepository.save(action);
	Assertions.assertThat(Updated.getTypeAt()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
		TypeAt action = actionRepository.findById(1L).get();
	actionRepository.delete(action);
	TypeAt action1 = null;
	Optional<TypeAt> optionalAction = actionRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}