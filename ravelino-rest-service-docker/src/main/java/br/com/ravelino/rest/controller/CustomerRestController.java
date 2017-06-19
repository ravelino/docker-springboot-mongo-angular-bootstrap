/**
 * 
 */
package br.com.ravelino.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.ravelino.mongodb.domain.Customer;
import br.com.ravelino.mongodb.repository.CustomerRepository;

/**
 * @author ravelino
 *
 */


@RestController
@RequestMapping("/v1/customers")
public class CustomerRestController {
	
	private final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public ResponseEntity<String> customerList() {
		
		final List<Customer> customers = new ArrayList<>();
		
		log.info("######## Procurando clientes");
		
		try {
			
			List<Customer> clientes = customerRepository.findAll();
			log.info("Clientes encontrados: {}", clientes.toString());
			
			customers.addAll(clientes);
			
		} catch (Exception e) {
			log.error("######### DEU ERRO");
			final Customer c = new Customer();
			c.firstName = "Rogerio";
			c.lastName = "Avelino da Silva";
			customers.add(c);
		}
		
		//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

		return ResponseEntity.ok(new Gson().toJson(customers));
		
        //return new Gson().toJson(customers);
    }

}
