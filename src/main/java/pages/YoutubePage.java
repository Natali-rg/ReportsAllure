package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YoutubePage {

    @FindBy(xpath = "//input[@id='search']")
    WebElement element;
    @FindBy(xpath = "//button[@id='search-icon-legacy']")
    WebElement buttonEnter;

    public YoutubePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void sentRequest(){
        element.sendKeys("no wor");
        buttonEnter.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
