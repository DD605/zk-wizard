/**
 *
 */
package be.scorgar.controller;

import java.security.Principal;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.ExecutionParam;
import org.zkoss.bind.annotation.Init;

import be.scorgar.dispatcher.AbstractDispatcher;
import be.scorgar.zk.components.ExecutionArgs;

/**
 * @author Dirk
 *
 */
public class AbstractVM {

	private Principal principal;

	@Init
	public void init(@ExecutionParam(AbstractDispatcher.PRINCIPAL) Principal principal) {
		this.principal = principal;
	}

	public void globalCommand(String name, ExecutionArgs args) {
		BindUtils.postGlobalCommand(null, null, name, args.getArgsMap());
	}

	public String getUserName() {
		return null == principal ? "(unknown-user)" : principal.getName();
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

}
