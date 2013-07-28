/**
 * 
 */
package be.scorgar.zk.components;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Window;

/**
 * @author Dirk
 *
 */
public abstract class Components {
	
	private Components(){};
	
	public static <T extends Component> T createComponent(Page page){
		return Components.createComponent(page, ExecutionArgs.emptyArgs());
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Component> T createComponent(Page page,  ExecutionArgs args){
		return (T) Executions.createComponents(page.getPage(), null, args.getArgsMap());
	}
	
	public static Window openModalWindow(Page page, ExecutionArgs args){
		Window window = (Window) createComponent(page, args);
		window.doModal();
		return window;
	}
}
