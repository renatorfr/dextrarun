package br.com.renatorfr.dextrarun.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Steps {
    @Id
    private Long id;
    private Integer duration;
    private String description;
    private String speed;

    private Steps() {
    }

    public Steps(Integer duration, String description, String speed) {
        this.duration = duration;
        this.description = description;
        this.speed = speed;
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
