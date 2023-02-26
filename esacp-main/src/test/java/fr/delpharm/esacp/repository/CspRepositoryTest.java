package fr.delpharm.esacp.repository;

import static org.junit.Assert.assertNotNull;

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

import fr.delpharm.esacp.domain.Csp;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CspTest {
	
	@Autowired
    private CspRepository actionRepository;
	
	
    @Test
    @Order(1)
    @Rollback(false)
    public void saveTest() {
    	Csp categorie = new Csp((long) 1 , "Csp", true);
    	actionRepository.save(categorie);

        assertNotNull(categorie);
        Assertions.assertThat(categorie.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(false)
    public void FindByIdTest(){
    	Csp action = actionRepository.findById(1L).get();
        Assertions.assertThat(action.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @Rollback(false)
    public void findAllTest(){
        List<Csp> actions = actionRepository.findAll();
        Assertions.assertThat(actions.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTest(){
    	Csp action = actionRepository.findById(1L).get();
    	action.setCsp("Bruce");
    	Csp Updated =  actionRepository.save(action);
        Assertions.assertThat(Updated.getCsp()).isEqualTo("Bruce");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteTest(){
    	Csp action = actionRepository.findById(1L).get();
    	actionRepository.delete(action);

    	Csp action1 = null;
        Optional<Csp> optionalAction = actionRepository.findById((long) 1);
        if(optionalAction.isPresent()){
        	action1 = optionalAction.get();
        }
        Assertions.assertThat(action1).isNull();
    }



}
