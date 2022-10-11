import driverConfig.Base;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import wiki.Language;
import wiki.WikiPage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;

@RunWith(Parameterized.class)
public class ClassWikiTest extends Base {
    WikiPage wikiPage;
    ResourceBundle bundle;
    Language lang;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Language.values());
    }

    public ClassWikiTest(Language lang) {
        this.lang = lang;
        bundle=ResourceBundle.getBundle(lang.getCode());
        driver.get("http://" + lang.getCode() + ".wikipedia.org/");
    }

    @Before
    public void beforeTestMethod() {
        if (wikiPage == null) {
            wikiPage = new WikiPage(driver);
        }
    }

    @After
    public void afterTestMethod() throws InterruptedException {
        Thread.sleep(2000);
    }


    @Test
    public void testTab1() throws UnsupportedEncodingException {
        if(lang.getCode().equals("ru")){
            Assert.assertEquals(wikiPage.getTextTab1(), new String(bundle.getString("menutab").getBytes(StandardCharsets.ISO_8859_1),"Cp1251"));
        }
        Assert.assertEquals(wikiPage.getTextTab1(),bundle.getString("menutab"));

    }
    @Test
    public void testTab2(){
        Assert.assertEquals(wikiPage.getTextTab2(),bundle.getString("menutab1"));
    }
    @Test
    public void testTab3(){
        Assert.assertEquals(wikiPage.getTextTab3(),bundle.getString("menutab2"));
    }


}
