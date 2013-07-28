/**
 *
 */
package be.scorgar.demo.controller.wizard;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;

import be.scorgar.controller.AbstractVM;
import be.scorgar.demo.controller.UserCatalogVM;
import be.scorgar.demo.domain.User;
import be.scorgar.demo.service.PeopleService;
import be.scorgar.demo.service.UserService;
import be.scorgar.dispatcher.AbstractDispatcher;

/**
 * @author Dirk
 *
 */
public class UserWizardVM extends AbstractVM {

	private PeopleService peopleService;
	private  UserService userService;
	private Component container;
	private User user;

	@Init(superclass=true)
	public void init(@ExecutionParam(AbstractDispatcher.PERSON_SERVICE) PeopleService peopleService, @ExecutionParam(AbstractDispatcher.USER_SERVICE) UserService userService,  @ExecutionParam(UserCatalogVM.USER) User user,  @BindingParam("wizard-container") Component container) {
		this.userService = userService;
		this.peopleService = peopleService;
		this.container = container;
		this.user = user;
		System.err.println(userService + " ~ "+ peopleService);
		System.err.println(container + " ~ "+ user);
	}


}
