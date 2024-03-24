package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        wd.findElement(locator).click();
    }

    public void type(By locator, String text){
        WebElement el = wd.findElement(locator);
                el.click();
                el.clear();
                if (text!=null){
                    el.sendKeys(text);
                }

    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator){
//        List<WebElement>list = wd.findElements(locator);
//        return list.size()>0;

        return wd.findElements(locator).size()>0;
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));

        WebElement el = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = el.isEnabled();

        return res && !result;
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }
}
