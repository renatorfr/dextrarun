package br.com.renatorfr.dextrarun;

import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.repository.TrainingRepositoryStub;
import br.com.renatorfr.dextrarun.viewmodel.TrainingRequest;
import br.com.renatorfr.dextrarun.viewmodel.TrainingResponse;
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
    public TrainingResponse getTraining(@Named("trainingId") Long id, User user) throws OAuthRequestException {
        validate(user);

        Training training = new TrainingRepositoryStub().getTraining(id);

        return new TrainingResponse(training);
    }

    @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST)
    public TrainingResponse addTraining(@Named("name") String name, @Named("jediMasterId") Long jediMaster, @Named("padwanId") Long padwan, User user) throws OAuthRequestException {
        validate(user);

        TrainingRequest trainingRequest = new TrainingRequest(0L, jediMaster, padwan, name);
        Training training = trainingRequest.createTraining();

        return new TrainingResponse(training);
    }

    private void validate(User user) throws OAuthRequestException {
        if (user == null) {
            throw new OAuthRequestException("Forbidden");
        }
    }
}
