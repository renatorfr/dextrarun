package br.com.renatorfr.dextrarun.viewmodel;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Step;
import br.com.renatorfr.dextrarun.domain.Training;

import java.util.ArrayList;
import java.util.List;

public class TrainingVM {
    private Long id;
    private Long jediMaster;
    private Long padwan;
    private String name;
    private List<StepVM> steps;

    private TrainingVM() {
    }

    public TrainingVM(Long id, Long jediMaster, Long padwan, String name, List<StepVM> steps) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
        this.steps = steps;
    }

    public TrainingVM(Long jediMaster, Long padwan, String name, List<StepVM> steps) {
        this(null, jediMaster, padwan, name, steps);
    }

    public TrainingVM(Training training) {
        this.id = training.getId();
        this.jediMaster = training.getJediMaster().getId();
        this.padwan = training.getPadwan().getId();
        this.name = training.getName();
        this.steps = getStepsVM(training.getSteps());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJediMaster() {
        return jediMaster;
    }

    public void setJediMaster(Long jediMaster) {
        this.jediMaster = jediMaster;
    }

    public Long getPadwan() {
        return padwan;
    }

    public void setPadwan(Long padwan) {
        this.padwan = padwan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSteps(List<StepVM> steps) {
        this.steps = steps;
    }

    public Training createTraining() {
        JediMaster jediMaster = new JediMaster(this.jediMaster, "Jedi Master " + this.jediMaster);
        Padwan padwan = new Padwan(this.padwan, "Padwan " + this.padwan);

        return new Training(id, jediMaster, padwan, name, getSteps());
    }

    private List<Step> getSteps() {
        List<Step> result = new ArrayList<>();

        for (StepVM step : steps) {
            result.add(step.createStep());
        }

        return result;
    }

    private List<StepVM> getStepsVM(List<Step> steps) {
        List<StepVM> result = new ArrayList<>();

        for (Step step : steps) {
            result.add(new StepVM(step));
        }

        return result;
    }
}
