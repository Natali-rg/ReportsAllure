import driverConfig.Base;
import hillel.MailForm;
import hillel.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import wiki.Language;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;
@RunWith(Parameterized.class)
public class MailFormTest extends Base {

    MailForm form;
    MainPage mainPage;
    String NAME;

    public MailFormTest(String NAME) {
        this.NAME = NAME;
    }

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList("Kate", "Nick");
    }

    @Before
    public void create(){
        if(form==null){
            form=new MailForm(driver);
        }
        if(mainPage==null){
            mainPage=new MainPage(driver);
        }
    }

    @After
    public void ass() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void testForm() {
        driver.get("https://ithillel.ua/");
        mainPage.clickConsultButton();
        ResourceBundle bundle=ResourceBundle.getBundle(NAME);
        form.create(bundle.getString("name"), bundle.getString("mail"),
                bundle.getString("tel"),bundle.getString("mass"),bundle.getString("course"), "ldklkkvjdl");
    }

}
