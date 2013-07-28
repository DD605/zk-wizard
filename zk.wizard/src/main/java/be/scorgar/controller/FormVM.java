/**
 * 
 */
package be.scorgar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;

/**
 * @author Dirk
 *
 */
public class FormVM extends AbstractVM {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(FormVM.class);
	
	public static final String FORM = "form";
	private Component form;
	
	@Init(superclass=true)
	public void init(@BindingParam(FormVM.FORM) Component form) {
		this.form = form;
		LOGGER.debug("init form: " + form);
	}
	
	protected Component getForm() {
		return form;
	}
	
	protected void detach() {
		form.detach();
	}
	
}
