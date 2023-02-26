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
import fr.delpharm.esacp.domain.User;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserRepositoryTest {
	
	@Autowired
	private UserRepository actionRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveTest() {
	User user =  new User((long) 9999,"password", "firstName", "lastName", "mail@mail.fr", true, (long)123456, null, true, true, (long) 406, (long) 1, (long)1, 
			(long)1, (long)1, (long)1, null ,  null,  null,   null, null, null );
	System.out.println(user);
	actionRepository.save(user);

	assertNotNull(user);
	Assertions.assertThat(user.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	public void FindByIdTest(){
	User categorie = actionRepository.findById(1L).get();
	Assertions.assertThat(categorie.getId()).isEqualTo((1L));
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	public void findAllTest(){
	List<User> actions = actionRepository.findAll();
	Assertions.assertThat(actions.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateTest(){
	User action = actionRepository.findById(1L).get();
	action.setFirstName("Bruce");
	User Updated = actionRepository.save(action);
	Assertions.assertThat(Updated.getFirstName()).isEqualTo("Bruce");
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteTest(){
	User action = actionRepository.findById(1L).get();
	actionRepository.delete(action);
	User action1 = null;
	Optional<User> optionalAction = actionRepository.findById((long) 1);
	if(optionalAction.isPresent()){
	action1 = optionalAction.get();
	}
	Assertions.assertThat(action1).isNull();
	}

	}
