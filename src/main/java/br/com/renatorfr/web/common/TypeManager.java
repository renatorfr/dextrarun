package br.com.renatorfr.web.common;

import br.com.renatorfr.controller.test.TestController;
import java.util.Arrays;
import java.util.List;

public enum TypeManager {

    testController(TestController.class);

    private Class<?> type;

    TypeManager(Class<?> type) {
        this.type = type;
    }

    private Class<?> getType() {
        return type;
    }

    public static Class<?> getClassType(String type) {
        List<TypeManager> types = Arrays.asList(TypeManager.values());
        return types.stream().filter(t -> t.name().equals(type)).findFirst().get().getType();
    }
}
