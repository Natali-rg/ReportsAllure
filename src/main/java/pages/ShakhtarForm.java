package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShakhtarForm {

    @FindBy(id = "commonFormLogin")
    WebElement formRow;

    @FindBy(xpath = "//*[@id=\"commonFormLogin\"]/div[3]/button")
    WebElement button;


    public ShakhtarForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sendData() {
        List<WebElement> list = formRow.findElements(By.xpath("//div[@class='form__row']"));
        //       System.out.println(list.size());
        for (WebElement l : list) {
            l.findElement(By.name("email")).sendKeys("turchyna.natali82@gmail.com");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            l.findElement(By.xpath("//*[@id=\"commonFormLogin\"]/div[2]/input")).sendKeys("na10081982");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            break;
        }
        button.click();
    }


}
