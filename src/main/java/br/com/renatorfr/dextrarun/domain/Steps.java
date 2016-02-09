package br.com.renatorfr.dextrarun.domain;

public class Steps {
    private final Integer duration;
    private final String description;
    private final String speed;

    public Steps(Integer duration, String description, String speed) {
        this.duration = duration;
        this.description = description;
        this.speed = speed;
    }
}
