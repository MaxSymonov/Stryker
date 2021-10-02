import Platform.AppiumServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {
    protected static AppiumServer server = new AppiumServer();

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        server.init();
    }

    @AfterClass
    public void tearDown(){
        server.stop();
    }
}
