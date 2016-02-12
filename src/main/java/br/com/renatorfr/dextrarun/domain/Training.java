package br.com.renatorfr.dextrarun.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Training {
    private final Long id;
    private final JediMaster jediMaster;
    private final Padwan padwan;
    private final String name;
    private final List<Steps> trainingSteps;
    private final Date dateCreated;

    public Training(JediMaster jediMaster, Padwan padwan, String name, List<Steps> trainingSteps) {
        this(null, jediMaster, padwan, name, trainingSteps, null);
    }

    public Training(Long id, JediMaster jediMaster, Padwan padwan, String name, List<Steps> trainingSteps, Date dateCreated) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
        this.trainingSteps = trainingSteps;
        this.dateCreated = dateCreated;
    }

    public Training(Long id, JediMaster jediMaster, Padwan padwan, String name, ArrayList<Steps> trainingSteps) {
        this(id, jediMaster, padwan, name, trainingSteps, null);
    }

    public Long getId() {
        return id;
    }

    public JediMaster getJediMaster() {
        return jediMaster;
    }

    public Padwan getPadwan() {
        return padwan;
    }

    public String getName() {
        return name;
    }

    public List<Steps> getTrainingSteps() {
        return trainingSteps;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
