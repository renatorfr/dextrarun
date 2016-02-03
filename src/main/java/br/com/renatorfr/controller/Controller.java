package br.com.renatorfr.controller;

import spark.Request;

public interface Controller {
    void initialize(Request request);

    Object execute();
}
