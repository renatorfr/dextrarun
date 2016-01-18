package br.com.renatorfr.web.common;

import br.com.renatorfr.web.handler.ParameterHandler;
import br.com.renatorfr.web.handler.ParameterHandlerFactory;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Binder {

    private static final String URI_REQUEST = "/done/(\\w+)/(\\w+)/?";
    private static final int TYPE = 1;
    private static final int TARGET = 2;

    private Matcher matcher;

    public Binder(String requestURI) {
        Pattern pattern = Pattern.compile(Binder.URI_REQUEST);
        this.initMatcher(requestURI, pattern);
    }

    public Object invoke(String json) throws Exception {
        Class<?> classType = TypeManager.getClassType(this.matcher.group(Binder.TYPE));
        Method method = this.findMethod(classType);
        Object[] params = this.createParameterValues(json, method);
        return method.invoke(classType.newInstance(), params);
    }

    private Object[] createParameterValues(String json, Method method) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        ParameterHandler handler = ParameterHandlerFactory.instance(parameterTypes);
        return handler.jsonToObjectArray(json, parameterTypes);
    }

    private Method findMethod(Class<?> classType) {
        Method methods[] = classType.getDeclaredMethods();
        String target = matcher.group(Binder.TARGET);
        int i = -1;
        do {
            i++;
        } while (!target.equals(methods[i].getName()) && i < methods.length);
        return methods[i];
    }

    private void initMatcher(String requestURI, Pattern pattern) {
        matcher = pattern.matcher(requestURI);
        matcher.matches();
    }

}
