package br.com.renatorfr;

import spark.Request;
import spark.Response;
import spark.Route;

import static br.com.renatorfr.controller.ControllersEnum.TRAINING_CONTROLLER;
import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
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
