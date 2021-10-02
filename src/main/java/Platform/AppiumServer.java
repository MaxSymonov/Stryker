package Platform;

import DeviceManagement.GetDeviceDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumServer extends GetDeviceDetails {

    public AppiumDriver driver;
    DesiredCapabilities capabilities;

    public void init() throws IOException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getDevicesName());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, getPlatformVersion());


        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }
}
