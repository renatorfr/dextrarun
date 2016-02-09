package br.com.renatorfr.dextrarun;

import br.com.renatorfr.dextrarun.controller.Controller;
import br.com.renatorfr.dextrarun.controller.ControllerFactory;
import br.com.renatorfr.dextrarun.controller.ControllersEnum;
import spark.Request;

public class RequestHandler {
    public static Object handle(ControllersEnum controllerClass, Request request) {
        Controller controller = ControllerFactory.fabricate(controllerClass.getClazz(), request);

        try {
            return controller.execute();
        } catch (Exception e) {
            return e;
        }
    }
}
