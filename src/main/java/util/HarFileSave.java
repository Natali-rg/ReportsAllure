package util;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.core.har.Har;

import java.io.File;

public class HarFileSave {
    public static  void saveHarFile(BrowserMobProxy browserMobProxy,String sFileName){
        Har har = browserMobProxy.getHar();
        System.out.println("Entries count :" + har.getLog().getEntries().size());

        File harFile = new File(sFileName);
        try {
            har.writeTo(harFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
