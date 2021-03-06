package hardcore.tests;

import hardcore.driver.DriverSingleton;
import hardcore.pages.CloudPage;
import hardcore.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;


@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected CloudPage cloudPage;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
        cloudPage = new CloudPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
