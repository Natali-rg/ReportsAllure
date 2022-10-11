import driverConfig.Base;

import hillel.MailForm;
import models.AGENTS;
import models.UserAgents;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.YoutubePage;
import util.HarFileSave;
import util.Screen;
import util.WorkWithLog;

import java.io.File;
import java.io.IOException;


public class ProxyTest extends Base {
    static YoutubePage youtubePage;
    @BeforeClass
    public static void initT(){
        AGENTS.AgentType(UserAgents.IPHONE);
        if(youtubePage==null){
            youtubePage=new YoutubePage(driver);
        }
    }

    @Test
    public void testP1() {
        driver.get("https://www.youtube.com/");
        youtubePage.sentRequest();
        Screen.takeScreen(driver,"Screen");

    }

    @AfterClass
    public static void end(){
        //HarFileSave.saveHarFile(server,"TestHar");
        WorkWithLog.saveLogFile(driver,"logTest");
        driver.close();


    }
}
