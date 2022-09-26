package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;



public class NewsPage {
    @FindBy(xpath = "//li[contains(@class, 'site-nav-menu_item') and contains(@ class, '-blog')] ")
    WebElement blogButton;

    @FindBy(xpath = "//li[@class=\"theme-list_item\"]")
    List<WebElement> listBlogMenu;

    @FindBy(xpath = "//ul[contains(@class, 'posts_list') and contains (@class, 'post-list')]")
    WebElement listNews;

    public NewsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public void clickBlogButton() {
        blogButton.click();
    }

    public void printHrefListBlogMenu() {
        for(WebElement l:listBlogMenu){
            System.out.println(l.findElement(By.tagName("a")).getAttribute("href"));
        }
    }
    public void clickBlogMenu(String name){
        for(WebElement l:listBlogMenu){
            if (l.findElement(By.tagName("a")).getAttribute("href").contains(name));
            l.click();
            break;
        }
    }

    public int getListNewsSize(){
        return listNews.findElements(By.tagName("li")).size();


    }

}




