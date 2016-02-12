package br.com.renatorfr.dextrarun.viewmodel;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Training;

public class TrainingResponse {
    private final Long id;
    private final JediMaster jediMaster;
    private final Padwan padwan;
    private final String name;

    public TrainingResponse(Training training) {
        this.id = training.getId();
        this.jediMaster = training.getJediMaster();
        this.padwan = training.getPadwan();
        this.name = training.getName();
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
}
