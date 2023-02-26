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

import fr.delpharm.esacp.domain.Rapport;
import fr.delpharm.esacp.domain.TypeAction;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RapportRepositoryTest {
	
	@Autowired
	private RapportRepository rapportRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	Rapport rapport =  new Rapport(null, null, "uap", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	rapportRepository.save(rapport);
	assertNotNull(rapport);
	Assertions.assertThat(rapport.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	Rapport rapport = rapportRepository.findById(1L).get();
	Assertions.assertThat(rapport.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<Rapport> actions = rapportRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	Rapport action = rapportRepository.findById(1L).get();
	action.setUap("Bruce");
	Rapport Updated = rapportRepository.save(action);
	Assertions.assertThat(Updated.getUap()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
		Rapport action = rapportRepository.findById(1L).get();
	rapportRepository.delete(action);
	Rapport action1 = null;
	Optional<Rapport> optionalAction = rapportRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}