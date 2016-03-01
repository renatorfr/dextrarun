package br.com.renatorfr.dextrarun.domain;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Training {
    @Id
    private Long id;
    private JediMaster jediMaster;
    private Padwan padwan;
    private String name;
    private List<Step> steps;
    private Date dateCreated;

    private Training() {
    }

    public Training(Long id, JediMaster jediMaster, Padwan padwan, String name, List<Step> steps) {
        this(id, jediMaster, padwan, name, steps, new Date());
    }

    public Training(Long id, JediMaster jediMaster, Padwan padwan, String name, List<Step> steps, Date dateCreated) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
        this.steps = steps;
        this.dateCreated = dateCreated;
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

    public List<Step> getSteps() {
        return steps;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
