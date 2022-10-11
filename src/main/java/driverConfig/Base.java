package driverConfig;

import driverConfig.BROWSER;
import driverConfig.DriverFactory;
import net.lightbody.bmp.BrowserMobProxyServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class Base {
    protected static WebDriver driver;
    public static BrowserMobProxyServer server;

    @BeforeClass
    public static void start() {
        driver=DriverFactory.getDriver(BROWSER.CHROMEPROXY);

    }

    @AfterClass
    public static void end(){
        driver.quit();
        server.stop();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
