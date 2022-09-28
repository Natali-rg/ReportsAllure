import driverConfig.Base;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import pages.ShakhtarForm;
import pages.ShakhtarHomePage;

@Feature("Test Shakhtar login")
@DisplayName("Test Shakhtar login")
public class ShakhtarRegistrationTest extends Base {
    private static String MAIN_URL = "https://shakhtar.com/";
    private static ShakhtarHomePage shakhtarHomePage;
    public static ShakhtarForm shakhtarForm= PageFactory.initElements(driver, ShakhtarForm.class);

    @BeforeClass
    public static void before(){
        driver.get(MAIN_URL);
        shakhtarHomePage=new ShakhtarHomePage(driver);


    }

    @Test
    @DisplayName("FormRegistrationTest")
    @Description("Open form registration")
    public void clickForm() {
        shakhtarHomePage.clickLoginForm();
    }

    @Test
    @DisplayName("LogInTest")
    @Description("Log in Shakhtar Site")
    public void logIn(){
        shakhtarForm.sendData();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
