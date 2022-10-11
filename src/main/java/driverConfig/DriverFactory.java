package driverConfig;

import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public static WebDriver getDriver(BROWSER brows) {
        WebDriver driver=null;
        switch (brows) {
            case CHROME:
                driver = initChrome();
                break;
            case FIREFOX:
                driver = initFireFox();
                break;
            case CHROMEPROXY:
                driver=initChromeProxy();
                break;
            case CROMEPROXYHAR:
                driver=initChromeProxyHar();
                break;
        }
        return driver;
    }

    private static WebDriver initChromeProxyHar() {
        BrowserMobProxyServer server = new BrowserMobProxyServer();
        server.setTrustAllServers(true);
        server.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);

        server.start();
        server.newHar("google");


        //
        // коннект с прокси
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        String hostIp = null;
        try {
            hostIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        seleniumProxy.setHttpProxy(hostIp + ":" + server.getPort());
        seleniumProxy.setSslProxy(hostIp + ":" + server.getPort());
        //
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setAcceptInsecureCerts(true);
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        WebDriver driver= new ChromeDriver(options);
        Base.server=server;
        return driver;
    }

    private static WebDriver initChromeProxy(){
        //создание прокси сервера
        BrowserMobProxyServer server = new BrowserMobProxyServer();
        server.setTrustAllServers(true);
        server.start();
        //
        // коннект с прокси
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(server);
        String hostIp = null;
        try {
            hostIp = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        seleniumProxy.setHttpProxy(hostIp + ":" + server.getPort());
        seleniumProxy.setSslProxy(hostIp + ":" + server.getPort());
        //
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        capabilities.setAcceptInsecureCerts(true);
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        WebDriver driver= new ChromeDriver(options);
        Base.server=server;
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
