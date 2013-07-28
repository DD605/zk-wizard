package be.scorgar.zk.components;

import java.util.HashMap;
import java.util.Map;

public class ExecutionArgs {
	
	private final Map<String, Object> args;
	
	private ExecutionArgs(){
		args = new HashMap<String, Object>();
	}
	
	public static ExecutionArgs emptyArgs() {
		return new ExecutionArgs();
	}
	
	public static ExecutionArgs with(String key, Object value) {
		ExecutionArgs executionArgs = new ExecutionArgs();
		executionArgs.args.put(key, value);
		return executionArgs;
	}
	
	public ExecutionArgs and(String key, Object value) {
		args.put(key, value);
		return this;
	}
	
	
	public Map<String, Object> getArgsMap() {
		return args;
	}
}
