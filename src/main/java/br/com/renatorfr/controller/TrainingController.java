package br.com.renatorfr.controller;

import br.com.renatorfr.viewmodel.TrainingViewModel;
import spark.Request;

public class TrainingController implements Controller {
    private TrainingViewModel trainingViewModel;

    @Override
    public void initialize(Request request) {
        this.trainingViewModel = new TrainingViewModel();
    }

    @Override
    public Object execute() {
        return "Hello training!";
    }
}
