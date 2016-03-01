package br.com.renatorfr.dextrarun;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.TrainingRepositoryObjectify;
import br.com.renatorfr.dextrarun.repository.interfaces.TrainingRepository;
import br.com.renatorfr.dextrarun.viewmodel.TrainingVM;
import com.google.api.server.spi.Constant;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;

@Api(name = "dextraRunApi",
     version = "v1",
     clientIds = {Constants.WEB_CLIENT_ID,
             Constant.API_EXPLORER_CLIENT_ID},
     namespace = @ApiNamespace(ownerDomain = "dextrarun.renatorfr.com.br",
                               ownerName = "renatorfr",
                               packagePath = ""))
public class DextraRunApi {
    @ApiMethod()
    public TrainingVM getTraining(@Named("trainingId") Long id, User user) throws OAuthRequestException {
        validate(user);

        Training training = new TrainingRepositoryObjectify().get(id);

        return new TrainingVM(training);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST)
    public TrainingVM addTraining(@Named("name") String name,
                                  @Named("jediMasterId") Long jediMaster,
                                  @Named("padwanId") Long padwan,
                                  User user) throws OAuthRequestException {
        validate(user);

        TrainingVM trainingVM = new TrainingVM(null, jediMaster, padwan, name, null);
        Training training = trainingVM.createTraining();

        TrainingRepository trainingRepository = new TrainingRepositoryObjectify();
        trainingRepository.save(training);

        return new TrainingVM(training);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST)
    public TrainingVM saveTraining(TrainingVM trainingVM,
                                   User user) throws OAuthRequestException {
        validate(user);

        Training training = trainingVM.createTraining();

        TrainingRepository trainingRepository = new TrainingRepositoryObjectify();
        trainingRepository.save(training);

        return new TrainingVM(training);
    }

    private void validate(User user) throws OAuthRequestException {
        if (user == null) {
            throw new OAuthRequestException("Forbidden");
        }
    }
}
