package br.com.renatorfr.dextrarun.controller;

import spark.Request;

public class ControllerFactory {
    public static Controller fabricate(Class clazz, Request request) {
        try {
            Controller controller = (Controller) clazz.newInstance();
            controller.initialize(request);

            return controller;
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }
}
