/**
 *
 */
package be.scorgar.demo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import be.scorgar.demo.domain.Person;
import be.scorgar.demo.repository.PersonRepository;

/**
 * @author Dirk
 *
 */
@Service
public class PeopleService {

	@Inject private PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person save(Person person) {
		return personRepository.save(person);
	}

	public void delete(Person person) {
		personRepository.delete(person);
	}

}
