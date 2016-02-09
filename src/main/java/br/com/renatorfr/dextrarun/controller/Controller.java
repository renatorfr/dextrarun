package br.com.renatorfr.dextrarun.controller;

import spark.Request;

public interface Controller {
    void initialize(Request request);

    Object execute();
}
