package fw;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;


public class TestBase {
    protected Logger log = Logger.getLogger("TEST");
    protected ApplicationManager app;

    @BeforeClass
    @Parameters({"configFile"})
    public void setUp(@Optional String configFile) throws Exception {
        if (configFile == null) {
            configFile = System.getProperty("configFile");
            }
        if (configFile == null) {
            configFile = System.getenv("configFile");
        }
        if (configFile == null) {
            configFile = "application.properties";
        }
        Properties props = new Properties();
        props.load(new FileReader(new File(configFile)));
        app = ApplicationManager.getInstance(props);
        app.setProperties(props);
    }

    @AfterTest
    public void tearDown() throws IOException {
        ApplicationManager.getInstance(null).stop();
    }

}
