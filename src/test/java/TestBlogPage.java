import org.junit.*;
import org.junit.runners.MethodSorters;
import pages.NewsPage;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBlogPage extends Base{
    private static String MAIN_URL = "https://ithillel.ua/";
    private static NewsPage newsPage;

    @BeforeClass
    public static void before(){
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
    public void aclickBlogNews() {
        newsPage.clickBlogButton();
        Assert.assertEquals(driver.getTitle(),"Корисні матеріали: Статті та новини IT-індустрії | Комп'ютерна школа Hillel");
        newsPage=new NewsPage(driver);
    }

    @Test
    public void bTestFrontEnd() {
//        newsPage.printHrefListBlogMenu();
        newsPage.clickBlogMenu("frontend");

        System.out.println("frontend ="+newsPage.getListNewsSize());
        driver.navigate().back();

    }
    @Test
    public void cTestBackEnd(){
        newsPage.clickBlogMenu("backend");
        System.out.println("backend ="+newsPage.getListNewsSize());
        driver.navigate().back();
    }
    @Test
    public void dTestDevops(){
        newsPage.clickBlogMenu("devops");
        System.out.println("devops ="+newsPage.getListNewsSize());
        driver.navigate().back();
    }

    @Test
    public void eTestQA(){
        newsPage.clickBlogMenu("qa");
        System.out.println("QA ="+newsPage.getListNewsSize());
    }
    @Test
    public void fTestMarketing(){
        newsPage.clickBlogMenu("marketing");
        System.out.println("marketing ="+newsPage.getListNewsSize());
    }

}
