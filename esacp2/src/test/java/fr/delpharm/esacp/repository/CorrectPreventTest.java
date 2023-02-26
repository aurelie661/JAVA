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

import fr.delpharm.esacp.domain.CorrectPrevent;


@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CorrectPreventTest {
	
	@Autowired
    private CorrectPreventRepository actionRepository;
	
	
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveTest() {
    	CorrectPrevent categorie = new CorrectPrevent((long) 1 , "CorrectPrevent", true);
    	actionRepository.save(categorie);

        assertNotNull(categorie);
        Assertions.assertThat(categorie.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void FindByIdTest(){
    	CorrectPrevent categorie = actionRepository.findById(1L).get();
        Assertions.assertThat(categorie.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void findAllTest(){
        List<CorrectPrevent> actions = actionRepository.findAll();
        Assertions.assertThat(actions.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateTest(){
    	CorrectPrevent action = actionRepository.findById(1L).get();
    	action.setCorrectPrevent("Bruce");
    	CorrectPrevent Updated =  actionRepository.save(action);
        Assertions.assertThat(Updated.getCorrectPrevent()).isEqualTo("Bruce");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteTest(){
    	CorrectPrevent action = actionRepository.findById(1L).get();
    	actionRepository.delete(action);

    	CorrectPrevent action1 = null;
        Optional<CorrectPrevent> optionalAction = actionRepository.findById((long) 1);
        if(optionalAction.isPresent()){
        	action1 = optionalAction.get();
        }
        Assertions.assertThat(action1).isNull();
    }



}
