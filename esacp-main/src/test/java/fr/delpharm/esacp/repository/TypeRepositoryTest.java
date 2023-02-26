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

import fr.delpharm.esacp.domain.Type;
import fr.delpharm.esacp.domain.TypeRapport;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeRepositoryTest {
	
	@Autowired
	private TypeRepository actionRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	Type type =  new Type((long) 1, "origine", "accOrigine", true, (long)1, null );
	actionRepository.save(type);
	assertNotNull(type);
	Assertions.assertThat(type.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	Type typeRapport = actionRepository.findById(1L).get();
	Assertions.assertThat(typeRapport.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<Type> actions = actionRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	Type action = actionRepository.findById(1L).get();
	action.setOrigine("Bruce");
	Type Updated = actionRepository.save(action);
	Assertions.assertThat(Updated.getOrigine()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
		Type action = actionRepository.findById(1L).get();
	actionRepository.delete(action);
	Type action1 = null;
	Optional<Type> optionalAction = actionRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}