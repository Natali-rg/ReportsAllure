package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShakhtarHomePage {
    @FindBy(xpath="//div[@class='topbar  ']")
    WebElement myLoginForm;
    public ShakhtarHomePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickLoginForm() {
        List<WebElement> list = myLoginForm.findElements(By.tagName("li"));
        for (WebElement l : list) {
            l.findElement(By.tagName("a")).getText().equals("Увійти");
            l.click();
            break;
        }

    }


}
