package Platform;

import DeviceManagement.HelperBase;

import java.io.IOException;

public class DefaultPackages extends HelperBase {

    public String getAndroidHomePageID() throws IOException, InterruptedException {
        return adbManipulator("adb shell cmd shortcut get-default-launcher");
    }
}
