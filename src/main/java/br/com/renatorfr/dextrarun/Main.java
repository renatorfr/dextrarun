package br.com.renatorfr.dextrarun;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.servlet.SparkApplication;

import static br.com.renatorfr.dextrarun.controller.ControllersEnum.TRAINING_CONTROLLER;
import static spark.Spark.get;

public class Main implements SparkApplication {
    @Override
    public void init() {
        get("/", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return "Hello Spark!";
            }
        });
        get("/training", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return RequestHandler.handle(TRAINING_CONTROLLER, request);
            }
        });
    }
}
