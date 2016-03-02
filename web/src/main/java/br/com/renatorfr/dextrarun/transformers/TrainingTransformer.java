package br.com.renatorfr.dextrarun.transformers;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.viewmodel.TrainingVM;
import com.google.api.server.spi.config.Transformer;

public class TrainingTransformer implements Transformer<Training, TrainingVM> {
    @Override
    public TrainingVM transformTo(Training training) {
        return new TrainingVM(training);
    }

    @Override
    public Training transformFrom(TrainingVM trainingVM) {
        return trainingVM.createTraining();
    }
}
