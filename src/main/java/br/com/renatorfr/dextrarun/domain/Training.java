package br.com.renatorfr.dextrarun.domain;

import java.util.Date;
import java.util.List;

public class Training {
    private final Long id;
    private final User jediMaster;
    private final User padwan;
    private final String name;
    private final List<Steps> trainingSteps;
    private final Date dateCreated;

    public Training(User jediMaster, User padwan, String name, List<Steps> trainingSteps) {
        this(null, jediMaster, padwan, name, trainingSteps, null);
    }

    public Training(Long id, User jediMaster, User padwan, String name, List<Steps> trainingSteps, Date dateCreated) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
        this.trainingSteps = trainingSteps;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public User getJediMaster() {
        return jediMaster;
    }

    public User getPadwan() {
        return padwan;
    }

    public List<Steps> getTrainingSteps() {
        return trainingSteps;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
