package br.com.renatorfr.web.handler;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ParameterHandlerObject extends ParameterHandler {

	@Override
	public Object[] jsonToObjectArray(String json, Class<?>[] type) {
		JsonElement jsonElement = new JsonParser().parse(json);
		return new Object[] { this.jsonToObject(jsonElement, type[0]) };
	}

}
