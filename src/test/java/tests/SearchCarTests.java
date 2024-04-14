package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {
    @BeforeMethod
    public void postCondition() {
        app.getHelperCar().navigateByLogo();
    }

    @Test
    public void searchCurrentMonthSuccess() {
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "4/25/2024", "4/28/2024");
        app.getHelperCar().getScreen("src/test/resources/screenshots/currentMonth.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYearSuccess() {
        app.getHelperCar().searchCurrentYear("Haifa", "4/27/2024", "6/28/2024");
        app.getHelperCar().getScreen("src/test/resources/screenshots/currentYear.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriodSuccess() {
        app.getHelperCar().searchAnyPeriod("Rehovot", "10/27/2024", "2/28/2025");
        app.getHelperCar().getScreen("src/test/resources/screenshots/any.png");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void negativeSearch() {
        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel", "1/10/2024", "10/10/2024");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperCar().getErrorText(), "You can't pick date before today");

    }
}
