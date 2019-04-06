package reactivemongo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import reactivemongo.models.Person;
import reactivemongo.services.PersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveMongoRestController {
	static final Logger log = LoggerFactory.getLogger(ReactiveMongoRestController.class);

	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "/getAll")
	public Flux<Person> getAll() {
		log.info("Hit getAll successfully");
		return personService.getAll();
	}
	
	@GetMapping(value = "/getById/{id}")
	public Mono<Person> getById(@PathVariable String id) {
		log.info("Hit getById successfully");
		return personService.getById(id);
	}
	
	@PostMapping(value = "/save")
	public Mono<Person> save(@RequestBody Person person) {
		log.info("Hit save successfully");
		return personService.save(person);
	}
	
}
