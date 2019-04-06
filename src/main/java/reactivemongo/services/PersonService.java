package reactivemongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactivemongo.models.Person;
import reactivemongo.repositories.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepo;
	
	public Flux<Person> getAll() {
		return personRepo.findAll();
	}
	
	public Mono<Person> getById(String id) {
		return personRepo.findById(id);
	}
	
	public Mono<Person> save(Person person) {
		return personRepo.save(person);
	}
	
}
