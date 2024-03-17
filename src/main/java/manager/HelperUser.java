package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }

    //overloading
    public void fillLoginForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
//        WebElement el = wd.findElement(By.cssSelector(".dialog-container>h2"));
//        String text = el.getText();
//        return text;
        //pause(5000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void clickOkButton() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//*[.=' Logout ']"));
    }
}
