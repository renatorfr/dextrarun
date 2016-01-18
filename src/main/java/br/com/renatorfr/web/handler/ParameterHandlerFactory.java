package br.com.renatorfr.web.handler;

public class ParameterHandlerFactory {

	public static ParameterHandler instance(Class<?>[] parameterTypes) {
		ParameterHandler handler = null;
		switch (parameterTypes.length) {
		case 0:
			handler = new ParameterHandlerEmpty();
			break;
		case 1:
			handler = new ParameterHandlerObject();
			break;
		default:
			handler = new ParameterHandlerArray();
			break;
		}
		return handler;
	}

}
