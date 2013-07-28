/**
 *
 */
package be.scorgar.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;

import be.scorgar.controller.FormVM;
import be.scorgar.demo.domain.Person;
import be.scorgar.zk.components.ExecutionArgs;

/**
 * @author Dirk
 *
 */
public class PersonFormVM extends FormVM {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonFormVM.class);
	private Person person;

	@Init(superclass=true)
	public void init(@ExecutionArgParam(PersonCatalogVM.PERSON) Person person) {
		this.person = person;
	}

	@Command
	public void save() {
		LOGGER.debug("save person: "+person);
		globalCommand(PersonCatalogVM.SAVE, ExecutionArgs.with(PersonCatalogVM.PERSON, person));
		detach();
	}

	@Command
	public void cancel() {
		LOGGER.debug("cancel person: "+person);
		detach();
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
