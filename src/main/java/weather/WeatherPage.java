package weather;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WeatherPage {
    @FindBy(xpath = "//span[@class='LanguageSelector--LanguageSelectorStatus--mXkYQ']")
    WebElement mova;
    @FindBy (xpath = "//a[@class='ListItem--listItem--2wQRK styles--listItem--3b2Ko styles--active--3X9QA Button--default--3zkvy']")
    WebElement day;
    @FindBy(xpath = "//div[@class='CurrentConditions--header--27uOE']")
    WebElement city;



    public WeatherPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public String getTextMova(){
        return mova.getText();
    }
    public String getDayText(){
        return day.getText();
    }
    public String getCityText(){
        return city.getText();
    }

}
