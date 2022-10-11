import driverConfig.Base;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import models.AGENTS;
import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.NewsPage;
import util.Screen;
import util.WatcherByTest;
@Feature("Test Hillel News")
@DisplayName("Test BlogPage Hillel")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BlogPageTest extends Base {

    @Rule
    public WatcherByTest watcherByTest=new WatcherByTest();

    private static String MAIN_URL = "https://ithillel.ua/";
    private static NewsPage newsPage;

    @BeforeClass
    public static void before(){
        server.addRequestFilter(AGENTS.setUserIphone());
        driver.get(MAIN_URL);
        newsPage=new NewsPage(driver);
    }

    @After
    public void nenuznuyMetod() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Story("Tests******")
    @Link("https://ithillel.ua/")
    @Description("Check of the correct Title")
    public void aclickBlogNews() {
        newsPage.clickBlogButton();
        Assert.assertEquals(driver.getTitle(),"Корисні матеріали: статті та новини IT-індустрії | Комп'ютерна школа Hillel");
        newsPage=new NewsPage(driver);
    }

    @Test
    @Issue("frontend")
    @Description("Count of FrontEnd news")
    public void bTestFrontEnd() {
//        newsPage.printHrefListBlogMenu();
        newsPage.clickBlogMenu("frontend");
        System.out.println("frontend ="+newsPage.getListNewsSize());
        driver.navigate().back();
//        Screen.takeScreen(driver,"Screen");//вызываем метод скриншот

    }
    @Test
    @Description("Count of BackEnd news")
    public void cTestBackEnd(){
        newsPage.clickBlogMenu("backend");
        System.out.println("backend ="+newsPage.getListNewsSize());
        driver.navigate().back();
    }
    @Test
    @Description("Count of Devops news")
    public void dTestDevops(){
        newsPage.clickBlogMenu("devops");
        System.out.println("devops ="+newsPage.getListNewsSize());
        driver.navigate().back();
    }

    @Test
    @Description("Count of QA news")
    public void eTestQA(){
        newsPage.clickBlogMenu("qa");
        System.out.println("QA ="+newsPage.getListNewsSize());
    }
    @Test
    @Description("Count of Marketing news")
    public void fTestMarketing(){
        newsPage.clickBlogMenu("marketing");
        System.out.println("marketing ="+newsPage.getListNewsSize());
    }

}
