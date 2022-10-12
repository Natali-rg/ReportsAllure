package weather;

import driverConfig.Base;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class WeatherTest extends Base {
    WeatherPage weatherPage;
    ResourceBundle bundle;
    Lang langw;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Lang.values());
    }

    public WeatherTest(Lang lang) {
        this.langw = lang;
        bundle=ResourceBundle.getBundle(lang.getCode());
        driver.get("https://weather.com/"+lang.getCode()+"/weather/today/l/UPXX0486:1:UP?Goto=Redirected");
    }

    @Before
    public void beforeTestMethod() {
        if (weatherPage == null) {
            weatherPage = new WeatherPage(driver);
        }
    }
    @After
    public void afterTestMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test
    public void checkMovaText(){
        Assert.assertEquals(weatherPage.getTextMova(),bundle.getString("mova"));


    }
    @Test
    public void checkDayText(){
        Assert.assertEquals(weatherPage.getDayText(), bundle.getString("day"));
    }
@Test
    public void checkCityText(){
        Assert.assertEquals(weatherPage.getCityText(), bundle.getString("city"));
}


}
