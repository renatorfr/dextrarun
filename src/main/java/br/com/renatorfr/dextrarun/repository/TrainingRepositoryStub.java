package br.com.renatorfr.dextrarun.repository;

import br.com.renatorfr.dextrarun.domain.JediMaster;
import br.com.renatorfr.dextrarun.domain.Padwan;
import br.com.renatorfr.dextrarun.domain.Steps;
import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.interfaces.TrainingRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TrainingRepositoryStub implements TrainingRepository {
    @Override
    public Training get(Long id) {
        JediMaster jediMaster = new JediMaster("Obi Wan");
        Padwan padwan = new Padwan("Anakin");
        Date date = Calendar.getInstance().getTime();

        return new Training(id, jediMaster, padwan, "Treino 1", new ArrayList<Steps>(), date);
    }

    @Override
    public Training save(Training training) {
        throw new UnsupportedOperationException("#save()");
    }
}
