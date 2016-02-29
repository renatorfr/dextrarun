package br.com.renatorfr.dextrarun.viewmodel;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Step;
import br.com.renatorfr.dextrarun.domain.Training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainingRequest {
    private final Long id;
    private final Long jediMaster;
    private final Long padwan;
    private final String name;
    private final List<HashMap<String, String>> steps;

    public TrainingRequest(Long id, Long jediMaster, Long padwan, String name, List<HashMap<String, String>> steps) {
        this.id = id;
        this.jediMaster = jediMaster;
        this.padwan = padwan;
        this.name = name;
        this.steps = steps;
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

    public List<HashMap<String, String>> getSteps() {
        return steps;
    }

    public Training createTraining() {
        JediMaster jediMaster = new JediMaster(this.jediMaster, "Jedi Master " + this.jediMaster);
        Padwan padwan = new Padwan(this.padwan, "Padwan " + this.padwan);

        List<Step> stepsList = new ArrayList<Step>();
        for (HashMap<String, String> step : steps) {
            stepsList.add(new Step(step));
        }

        return new Training(jediMaster, padwan, name, stepsList);
    }
}
