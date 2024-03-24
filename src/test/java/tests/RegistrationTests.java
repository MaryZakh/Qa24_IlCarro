package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void registrationSuccess(){
//        Random random = new Random();
//        int i = random.nextInt(1000);
//        System.out.println(i);
//        System.out.println("**********");
//
        System.out.println(System.currentTimeMillis());
        int y = (int)(System.currentTimeMillis()/1000)%3600;
//        System.out.println("**********");
//
//        System.out.println(y);

        User user = new User()
                .withFirstName("Lisa")
                .withLastName("Snow")
                .withEmail("snow"+y+"@gmail.com")
                .withPassword("Snow123456$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");


    }
    @AfterMethod
    public void postCondition() {
        app.getHelperUser().clickOkButton();
    }

}
