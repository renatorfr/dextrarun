package br.com.renatorfr.web.handler;

public class ParameterHandlerEmpty extends ParameterHandler {

	@Override
	public Object[] jsonToObjectArray(String json, Class<?>[] type) {
		return new Object[] {};
	}

}
