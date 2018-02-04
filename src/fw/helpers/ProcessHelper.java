package fw.helpers;

import fw.ApplicationManager;

import java.io.IOException;

public class ProcessHelper extends HelperBase {
    private Process exec;

    public ProcessHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void startApp() throws IOException {
        String comand = manager.getProperties("app.path");
        exec = Runtime.getRuntime().exec(comand);
    }

    public void stopApp() {
        exec.destroy();
    }


}
