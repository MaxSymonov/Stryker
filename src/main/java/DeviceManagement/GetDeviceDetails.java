package DeviceManagement;

import java.io.IOException;

public class GetDeviceDetails extends HelperBase {
    public static String getDevicesName() throws IOException, InterruptedException {
        return adbManipulator("adb get-serialno");
    }

    public static String getPlatformVersion() throws IOException, InterruptedException {
        return adbManipulator("adb shell getprop ro.build.version.release");
    }
}
