package br.com.renatorfr.dextrarun.viewmodel;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Steps;
import br.com.renatorfr.dextrarun.domain.Training;

import java.util.ArrayList;

public class TrainingRequest {
    private final Long id;
    private final Long jediMaster;
    private final Long padwan;
    private final String name;

    public TrainingRequest(Long id, Long jediMaster, Long padwan, String name) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getJediMaster() {
        return jediMaster;
    }

    public Long getPadwan() {
        return padwan;
    }

    public String getName() {
        return name;
    }

    public Training createTraining() {
        JediMaster jediMaster = new JediMaster(this.jediMaster, "Jedi Master " + this.jediMaster);
        Padwan padwan = new Padwan(this.padwan, "Padwan " + this.padwan);

        return new Training(jediMaster, padwan, name, new ArrayList<Steps>());
    }
}
