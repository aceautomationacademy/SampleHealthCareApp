import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    static AppiumDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        openMobileApp();
    }

    public static void openMobileApp() throws MalformedURLException, InterruptedException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("autoGrantPermissions", true);
        cap.setCapability("deviceName","sdk_gphone64_x86_64");
        cap.setCapability("udid","emulator-5554");
        cap.setCapability("platformName","ANDROID");
        cap.setCapability("platformVersion","14");
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("appPackage","org.simple.clinic.staging");
        cap.setCapability("appActivity","org.simple.clinic.setup.SetupActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver(url, cap);

        Thread.sleep(20000);

        driver.findElement(new By.ByXPath("//android.widget.Button[@resource-id=\"org.simple.clinic.staging:id/nextButton\"]")).click();

        String actualSearchHyperTension = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introOneTextView\")")).getText();
        assertEquals("Search & find \n" +
                "thousands of patients \n" +
                "with hypertension", actualSearchHyperTension );


        String actualBloodPressure = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introTwoTextView\")")).getText();
        assertEquals("Maintain records of \n" +
                "blood pressures \n" +
                "& medicines", actualBloodPressure);

        String actualReminderMessage = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/introThreeTextView\")")).getText();
        assertEquals("Patients receive\n" +
                "reminder messages\n" +
                "to return for visits", actualReminderMessage);

        Thread.sleep(2000);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/getStartedButton\")")).click();

        Thread.sleep(2000);

        String actualTermsUsage = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Terms of Use\")")).getText();
        assertEquals("Terms of Use", actualTermsUsage);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.Button\")")).click();
        Thread.sleep(3000);

        String actualFirstCountry = driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"India\")")).getText();
        assertEquals("India", actualFirstCountry);

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"India\")")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Diamond Islands\")")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/phoneNumberEditText\")")).sendKeys("1212121");
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/nextButton\")")).click();
        Thread.sleep(2000);
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"org.simple.clinic.staging:id/pinEditText\")")).sendKeys("1212");





    }

}
