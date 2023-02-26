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
import fr.delpharm.esacp.domain.TypeAction;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeActionRepositoryTest {
	
	@Autowired
	private TypeActionRepository actionRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	TypeAction type =  new TypeAction((long) 1,"typeAction", true);
	actionRepository.save(type);
	assertNotNull(type);
	Assertions.assertThat(type.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	TypeAction typeAction = actionRepository.findById(1L).get();
	Assertions.assertThat(typeAction.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<TypeAction> actions = actionRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	TypeAction action = actionRepository.findById(1L).get();
	action.setTypeAction("Bruce");
	TypeAction Updated = actionRepository.save(action);
	Assertions.assertThat(Updated.getTypeAction()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
		TypeAction action = actionRepository.findById(1L).get();
	actionRepository.delete(action);
	TypeAction action1 = null;
	Optional<TypeAction> optionalAction = actionRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}