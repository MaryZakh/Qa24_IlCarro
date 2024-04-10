package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelperBase {

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement el = wd.findElement(locator);
        el.click();
        el.clear();
        clearNew(el);
        if (text != null) {
            el.sendKeys(text);
        }

    }

    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);

    }

    public String getMessage() {
//        WebElement el = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = el.getText();
//        return text;
        //pause(5000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator) {
//        List<WebElement>list = wd.findElements(locator);
//        return list.size()>0;

        return wd.findElements(locator).size() > 0;
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

    public void getScreen(String link) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) wd;
        File tmp = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File(link));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearTextBox(By locator) {
        WebElement el = wd.findElement(locator);
        String os = System.getProperty("os.name");
        System.out.println(os);
        if (os.startsWith("Win")) {
            el.sendKeys(Keys.CONTROL, "a");
        } else {
            el.sendKeys(Keys.COMMAND, "a");

        }
        el.sendKeys(Keys.DELETE);

    }
}
