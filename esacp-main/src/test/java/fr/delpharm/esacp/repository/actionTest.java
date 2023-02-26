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

import fr.delpharm.esacp.domain.Action;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ActionTest {
	
	@Autowired
    private ActionRepository actionRepository;

    @Test
    @Order(1)
    @Rollback(false)
    public void saveTest() {
    	Action categorie = new Action((long) 1 , "Csp", true, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    	actionRepository.save(categorie);

        assertNotNull(categorie);
        Assertions.assertThat(categorie.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(false)
    public void FindByIdTest(){
    	Action action = actionRepository.findById(1L).get();
        Assertions.assertThat(action.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @Rollback(false)
    public void findAllTest(){
        List<Action> actions = actionRepository.findAll();
        Assertions.assertThat(actions.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTest(){
    	Action action = actionRepository.findById(1L).get();
    	action.setTitre("Bruce");
    	Action Updated =  actionRepository.save(action);
        Assertions.assertThat(Updated.getTitre()).isEqualTo("Bruce");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteTest(){
    	Action action = actionRepository.findById(1L).get();
    	actionRepository.delete(action);

    	Action action1 = null;
        Optional<Action> optionalAction = actionRepository.findById((long) 1);
        if(optionalAction.isPresent()){
        	action1 = optionalAction.get();
        }
        Assertions.assertThat(action1).isNull();
    }



}
