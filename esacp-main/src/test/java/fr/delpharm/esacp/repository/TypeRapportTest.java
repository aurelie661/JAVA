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

import fr.delpharm.esacp.domain.TypeRapport;
import fr.delpharm.esacp.domain.User;
import fr.delpharm.esacp.repository.TypeRapportRepository;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TypeRapportTest {
	
	@Autowired
	private TypeRapportRepository actionRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	TypeRapport typeRapport =  new TypeRapport((long) 1, "test", true );
	actionRepository.save(typeRapport);
	assertNotNull(typeRapport);
	Assertions.assertThat(typeRapport.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	TypeRapport typeRapport = actionRepository.findById(1L).get();
	Assertions.assertThat(typeRapport.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<TypeRapport> actions = actionRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	TypeRapport action = actionRepository.findById(1L).get();
	action.setTypeRapport("Bruce");
	TypeRapport Updated = actionRepository.save(action);
	Assertions.assertThat(Updated.getTypeRapport()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
		TypeRapport action = actionRepository.findById(1L).get();
	actionRepository.delete(action);
	TypeRapport action1 = null;
	Optional<TypeRapport> optionalAction = actionRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}