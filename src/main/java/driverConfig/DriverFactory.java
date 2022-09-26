package driverConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getDriver(BROWSER brows) {
        WebDriver driver=null;
        BROWSER browser=brows;
        switch (browser) {
            case CHROME:
                driver = initChrome();
                break;
            case FIREFOX:
                driver = initFireFox();
                break;
        }
        return driver;
    }

    private static WebDriver initFireFox() {

        return new FirefoxDriver();
    }

    private static WebDriver initChrome() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--incognito");//открывает хром в режиме инкогнито
        //options.addArguments("--headless");//выполняет код без открытия браузера
        options.addArguments("--start-maximized");//открывает хром в полноекранном режиме
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}
