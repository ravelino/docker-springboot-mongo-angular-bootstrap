package br.com.ravelino.mongodb.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ravelino.mongodb.config.MongoConfig;
import br.com.ravelino.mongodb.domain.Customer;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=MongoConfig.class)
public class CustomerRepositoryTest {
	
	@Autowired
    private CustomerRepository customerRepository;
	
	
	@Before
	public void init() {
		customerRepository.deleteAll();
		customerRepository.save(new Customer("Alice", "Smith"));
		customerRepository.save(new Customer("Bob", "Smith"));
		customerRepository.save(new Customer("Luzinete", "Avelino da Silva"));
	}
	
	
	@Test
    public void findByFirstNameTest(){
		Customer userA = customerRepository.findByFirstName("Luzinete");
        assertNotNull(userA);
    }
	
	@Test
    public void findByIdTest(){
		Customer userA = customerRepository.findByFirstName("Luzinete");
		Customer luzinete = customerRepository.findById(userA.getId());
        assertNotNull(luzinete);
    }

}
