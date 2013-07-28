/**
 *
 */
package be.scorgar.demo.controller;

import java.util.List;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;

import be.scorgar.controller.AbstractVM;
import be.scorgar.demo.domain.Person;
import be.scorgar.demo.service.PeopleService;
import be.scorgar.dispatcher.AbstractDispatcher;
import be.scorgar.zk.components.Components;
import be.scorgar.zk.components.ExecutionArgs;
import be.scorgar.zk.components.Page;

/**
 * @author Dirk
 *
 */
public class PersonCatalogVM extends AbstractVM{

	public static final String SAVE = "SAVE";
	public static final String UPDATE = "UPDATE";

	private static final String PERSON_FORM_URI = "demo/domain/person-form";
	public static final String PERSON = "person";
	private List<Person> people;
	private Person person;
	private PeopleService peopleService;

	@Init(superclass=true)
	public void init(@ExecutionParam(AbstractDispatcher.PERSON_SERVICE) PeopleService peopleService) {
		this.peopleService = peopleService;
		people = peopleService.findAll();
	}

	@Command
	public void openPersonForm(){
		Components.openModalWindow(Page.uri(PERSON_FORM_URI), ExecutionArgs.with(PERSON, new Person()));
	}

	@Command
	public void updatePersonForm(){
		if(null == person) {
			person = new Person();
		}
		Components.openModalWindow(Page.uri(PERSON_FORM_URI), ExecutionArgs.with(PERSON, person));
	}

	@NotifyChange({"people","person"})
	@Command
	public void deletePerson(){
		if(null != person) {
			peopleService.delete(person);
			refresh();
		}
	}

	@GlobalCommand(SAVE)
	@NotifyChange({"people","person"})
	public void addPerson(@BindingParam(PERSON) Person person) {
		person = peopleService.save(person);
		refresh();
	}


	@Command
	@NotifyChange("people")
	public void refresh() {
		people = peopleService.findAll();
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}
}
