package br.com.renatorfr.dextrarun.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.HashMap;

@Entity
public class Step {
    @Id
    private Long id;
    private Integer duration;
    private String description;
    private String speed;

    private Step() {
    }

    public Step(Integer duration, String description, String speed) {
        this.duration = duration;
        this.description = description;
        this.speed = speed;
    }

    public Step(HashMap<String, String> step) {
        try{
            this.duration = Integer.valueOf(step.get("duration"));
        } catch (NumberFormatException e){
            this.duration = 0;
        }

        this.description = step.get("description");
        this.speed = step.get("speed");
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
}
