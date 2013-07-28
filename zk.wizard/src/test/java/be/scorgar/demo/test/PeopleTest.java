package be.scorgar.demo.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import be.scorgar.demo.repository.PersonRepository;

public class PeopleTest extends DevTest{
	
	@Inject private PersonRepository personRepository;
	
	@Test
	public void testFindPeople() throws Exception {
		Assert.assertFalse(personRepository.findAll().isEmpty());
	}
	
}
