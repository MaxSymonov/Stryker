package DeviceManagement;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelperBase {

    AppiumDriver driver;

    public static String adbManipulator(String shellCommand) throws IOException, InterruptedException {
        String result;

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", shellCommand);
        builder.redirectErrorStream(true);
        Process WinProcess = builder.start();
        BufferedReader output = new BufferedReader(new InputStreamReader(WinProcess.getInputStream()));
        result = output.readLine();
        WinProcess.waitFor();

        return result;
    }

    public void tap(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        tap(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void closeKeyboard() {
        driver.hideKeyboard();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void waitUntilClickable(By locator) {
        waitForElement(locator).click();
    }

    public void waitAndType(By locator, String text) {
        if (text != null) {
            waitUntilClickable(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
