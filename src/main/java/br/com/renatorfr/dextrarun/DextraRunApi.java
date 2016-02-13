package br.com.renatorfr.dextrarun;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.TrainingRepositoryStub;
import br.com.renatorfr.dextrarun.viewmodel.TrainingRequest;
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
    @ApiMethod()
    public TrainingResponse getTraining(@Named("trainingId") Long id) {
        Training training = new TrainingRepositoryStub().getTraining(id);

        return new TrainingResponse(training);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST)
    public TrainingResponse addTraining(@Named("name") String name, @Named("jediMasterId") Long jediMaster, @Named("padwanId") Long padwan) {
        TrainingRequest trainingRequest = new TrainingRequest(0L, jediMaster, padwan, name);
        Training training = trainingRequest.createTraining();

        return new TrainingResponse(training);
    }
}
