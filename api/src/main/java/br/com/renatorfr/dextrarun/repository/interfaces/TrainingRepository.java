package br.com.renatorfr.dextrarun.repository.interfaces;

import br.com.renatorfr.dextrarun.domain.Training;

public interface TrainingRepository {
    Training get(Long id);

    Training save(Training training);
}
