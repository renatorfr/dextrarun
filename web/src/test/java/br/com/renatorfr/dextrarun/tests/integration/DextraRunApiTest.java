package br.com.renatorfr.dextrarun.tests.integration;

import br.com.renatorfr.dextrarun.DextraRunApi;
import br.com.renatorfr.dextrarun.viewmodel.TrainingVM;
import com.google.appengine.api.users.User;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DextraRunApiTest {

    private final LocalServiceTestHelper testHelper = new LocalServiceTestHelper(
            new LocalDatastoreServiceTestConfig()
    );

    private Closeable obf;
    private User user;

    @Before
    public void setUp() throws Exception {
        testHelper.setUp();
        obf = ObjectifyService.begin();

        this.user = new User("example@example.com", "authDomain");
    }

    @After
    public void tearDown() throws Exception {
        testHelper.tearDown();
        obf.close();
    }

    @Test
    public void testGetTraining() throws Exception {
        TrainingVM training = new DextraRunApi().getTraining(5629499534213120L, user);

        assertEquals("Treino 1", training.getName());
    }
}
