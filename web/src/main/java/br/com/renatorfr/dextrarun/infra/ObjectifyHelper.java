package br.com.renatorfr.dextrarun.infra;

import br.com.renatorfr.dextrarun.domain.Step;
import br.com.renatorfr.dextrarun.domain.Training;
import br.com.renatorfr.dextrarun.domain.User;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class ObjectifyHelper {
    static {
        ObjectifyService.register(Training.class);
        ObjectifyService.register(User.class);
        ObjectifyService.register(Step.class);
    }

    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
