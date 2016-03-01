package br.com.renatorfr.dextrarun.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

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
        this(null, duration, description, speed);
    }

    public Step(Long id, Integer duration, String description, String speed) {
        this.id = id;
        this.duration = duration;
        this.description = description;
        this.speed = speed;
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
}
