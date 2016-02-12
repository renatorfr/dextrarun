package br.com.renatorfr.dextrarun.repository.interfaces;

import br.com.renatorfr.dextrarun.domain.Training;

public interface TrainingRepository {
    Training getTraining(Long id);
}
