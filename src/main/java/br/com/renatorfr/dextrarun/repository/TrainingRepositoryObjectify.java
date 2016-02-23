package br.com.renatorfr.dextrarun.repository;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.infra.ObjectifyHelper;
import br.com.renatorfr.dextrarun.repository.interfaces.TrainingRepository;
import com.googlecode.objectify.Objectify;

public class TrainingRepositoryObjectify implements TrainingRepository {

    @Override
    public Training get(Long id) {
        throw new UnsupportedOperationException("#get()");
    }

    @Override
    public Training save(Training training) {
        Objectify ofy = ObjectifyHelper.ofy();
        ofy.save().entity(training).now();

        return training;
    }
}
