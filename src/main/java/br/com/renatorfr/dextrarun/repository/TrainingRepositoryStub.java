package br.com.renatorfr.dextrarun.repository;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Steps;
import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.interfaces.TrainingRepository;

import java.util.ArrayList;

public class TrainingRepositoryStub implements TrainingRepository {
    @Override
    public Training getTraining(Long id) {
        JediMaster jediMaster = new JediMaster("Obi Wan");
        Padwan padwan = new Padwan("Anakin");
        return new Training(id, jediMaster, padwan, "Treino 1", new ArrayList<Steps>());
    }
}
