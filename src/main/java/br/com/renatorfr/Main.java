package br.com.renatorfr;

import static br.com.renatorfr.controller.ControllersEnum.TRAINING_CONTROLLER;
import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        get("/", (request, response) -> "Hello Spark!");
        get("/training", (request, response) -> RequestHandler.handle(TRAINING_CONTROLLER, request));
    }
}
