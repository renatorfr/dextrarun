package br.com.renatorfr.dextrarun;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.TrainingRepositoryStub;
import br.com.renatorfr.dextrarun.viewmodel.TrainingResponse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;

@Api(name = "dextraRunApi",
     version = "v1",
     namespace = @ApiNamespace(ownerDomain = "dextrarun.renatorfr.com.br",
                               ownerName = "renatorfr",
                               packagePath = ""))
public class DextraRunApi {
    @ApiMethod(name = "getTraining")
    public TrainingResponse getTraining(@Named("trainingId") Long id) {
        Training training = new TrainingRepositoryStub().getTraining(id);

        return new TrainingResponse(training);
    }

    @ApiMethod(name = "postTraining",
               httpMethod = ApiMethod.HttpMethod.POST)
    public Long postTraining(Training training) {
        return training.getId();
    }
}
