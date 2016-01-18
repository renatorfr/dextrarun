package br.com.renatorfr.web.handler;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ParameterHandlerArray extends ParameterHandler {

	@Override
	public Object[] jsonToObjectArray(String json, Class<?>[] type) {
		JsonElement jsonElement = new JsonParser().parse(json);
		JsonArray array = JsonArray.class.cast(jsonElement);
		Object params[] = new Object[array.size()];
		for (int i = 0; i < array.size(); i++) {
			params[i] = this.jsonToObject(array.get(i), type[i]);
		}
		return params;
	}

}
