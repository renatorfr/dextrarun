package br.com.renatorfr.dextrarun.viewmodel;

import br.com.renatorfr.dextrarun.domain.Step;

public class StepVM {
    private Long id;
    private Integer duration;
    private String description;
    private String speed;

    private StepVM() {
    }

    public StepVM(Long id, Integer duration, String description, String speed) {
        this.id = id;
        this.duration = duration;
        this.description = description;
        this.speed = speed;
    }

    public StepVM(Integer duration, String description, String speed) {
        this(null, duration, description, speed);
    }

    public StepVM(Step step) {
        this.id = step.getId();
        this.duration = step.getDuration();
        this.description = step.getDescription();
        this.speed = step.getSpeed();
    }

    public Long getId() {
        return id;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public String getSpeed() {
        return speed;
    }

    public Step createStep() {
        return new Step(id, duration, description, speed);
    }
}
