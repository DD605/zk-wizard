package be.scorgar.demo.dispatcher;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import be.scorgar.demo.service.PeopleService;
import be.scorgar.demo.service.UserService;
import be.scorgar.dispatcher.AbstractDispatcher;

@Controller
public class DemoDispatcher extends AbstractDispatcher {

	@Inject
	private PeopleService peopleService;

	@Inject
	private UserService userService;


	@RequestMapping(value = "/people", method = RequestMethod.GET)
	public String people(Model model, Principal principal) {
		model.addAttribute(PRINCIPAL, principal);
		model.addAttribute(PERSON_SERVICE, peopleService);
		return "demo/domain/person-catalog";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String users(Model model, Principal principal) {
		model.addAttribute(PRINCIPAL, principal);
		model.addAttribute(USER_SERVICE, userService);
		model.addAttribute(PERSON_SERVICE, peopleService);
		return "demo/domain/user-catalog";
	}

}
