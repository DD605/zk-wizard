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
import be.scorgar.demo.domain.User;
import be.scorgar.demo.service.UserService;
import be.scorgar.dispatcher.AbstractDispatcher;
import be.scorgar.zk.components.Components;
import be.scorgar.zk.components.ExecutionArgs;
import be.scorgar.zk.components.Page;

/**
 * @author Dirk
 *
 */
public class UserCatalogVM extends AbstractVM{

	public static final String SAVE = "SAVE";

	private static final String USER_WIZARD_URI = "demo/domain/user-wizard";
	public static final String USER = "user";
	private List<User> users;
	private UserService userService;


	@Init(superclass=true)
	public void init(@ExecutionParam(AbstractDispatcher.USER_SERVICE) UserService userService) {
		this.userService = userService;
		users = userService.findAll();
	}

	@Command
	public void openUserWizard(){
		Components.openModalWindow(Page.uri(USER_WIZARD_URI), ExecutionArgs.with(USER, new User()));
	}

	@GlobalCommand(SAVE)
	@NotifyChange("users")
	public void addPerson(@BindingParam(USER) User user) {
		userService.save(user);
		users.add(user);
	}

	@Command
	@NotifyChange("people")
	public void refresh() {
		users = userService.findAll();
	}

	public List<User> getUsers() {
		return users;
	}
}
