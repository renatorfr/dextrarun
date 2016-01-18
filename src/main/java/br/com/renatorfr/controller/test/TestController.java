package br.com.renatorfr.controller.test;

import br.com.renatorfr.entity.test.AddressEntity;
import br.com.renatorfr.entity.test.PersonEntity;

public class TestController {

	public String testEmptyParams() {
		return "Invoke method testEmptyParams()";
	}

	public PersonEntity testObjectParams(PersonEntity person) {
		return person;
	}

	public Long testSimpleParam(Long id) {
		return id;
	}

	public String testArrayParams(PersonEntity person, AddressEntity addr) {
		return new StringBuilder(person.getId().toString()).append(addr.getId()).toString();
	}

}
