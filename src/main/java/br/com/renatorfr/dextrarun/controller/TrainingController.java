package br.com.renatorfr.dextrarun.controller;

import br.com.renatorfr.dextrarun.viewmodel.TrainingViewModel;
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
