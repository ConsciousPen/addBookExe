package fw;

import fw.helpers.AutoItHelper;
import fw.helpers.ContactHelper;
import fw.helpers.ProcessHelper;

import java.io.IOException;
import java.util.Properties;


public class ApplicationManager {

    private Properties properties;
    private static ApplicationManager singleton;
    private ContactHelper contactHelper;
    private ProcessHelper processHelper;
    private AutoItHelper autoItHelper;


    public static ApplicationManager getInstance(Properties props) throws IOException {
        if (singleton == null) {
            singleton = new ApplicationManager();
            singleton.setProperties(props);
            singleton.start();
        }
        return singleton;
    }

    public void start() throws IOException {
        getProcessHelper().startApp();
    }

    public void stop() {
        getProcessHelper().stopApp();
    }

    public void setProperties(Properties props) {
        this.properties = props;
    }

    public String getProperties(String key) {
        return properties.getProperty(key);
    }

    public ContactHelper getContactHelper() {
        if (contactHelper == null) {
            contactHelper = new ContactHelper(this);
        }
        return contactHelper;
    }

    public ProcessHelper getProcessHelper() {
        if (processHelper == null) {
            processHelper = new ProcessHelper(this);
        }
        return processHelper;
    }

    public AutoItHelper getAutoItHelper() {
        if (autoItHelper == null) {
            autoItHelper = new AutoItHelper(this);
        }
        return autoItHelper;
    }

}
