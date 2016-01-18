package br.com.renatorfr.web.handler;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public abstract class ParameterHandler {

	private Gson gson;

	public ParameterHandler() {
		this.gson = new Gson();
	}

	public abstract Object[] jsonToObjectArray(String json, Class<?> type[]);

	protected <T> T jsonToObject(JsonElement json, Class<T> type) {
		return gson.fromJson(json, type);
	}

}
