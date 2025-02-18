package com.trae.automation.base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected AppiumDriver driver;

    @BeforeMethod
    @Parameters({"platform"})
    public void setup(String platform) throws Exception {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        if (platform.equalsIgnoreCase("Android")) {
            UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("Android Device")
                .setApp(System.getProperty("user.dir") + "/apps/your-android-app.apk")
                .setAutomationName("UiAutomator2");
            
            driver = new AndroidDriver(url, options);
        } else if (platform.equalsIgnoreCase("iOS")) {
            XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone")
                .setApp(System.getProperty("user.dir") + "/apps/your-ios-app.ipa")
                .setAutomationName("XCUITest");
            
            driver = new IOSDriver(url, options);
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}