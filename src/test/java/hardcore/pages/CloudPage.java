package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudPage extends BasePage {

    private final By SEARCH_ICON = By.className("devsite-search-form");
    private final By CALCULATOR = By.linkText("Google Cloud Platform Pricing Calculator");
    private final By SEARCH_INPUT = By.xpath("//input[@class='devsite-search-field devsite-search-query']");

    public CloudPage(WebDriver driver) {
        super(driver);
    }

    private final Logger logger = LogManager.getRootLogger();

    public CloudPage openPage() {
        driver.get("https://cloud.google.com/");
        logger.info("Cloud page is open");
        return this;
    }

    public CloudPage expandSearch() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_ICON));
        driver.findElement(SEARCH_ICON).click();
        logger.info("Search icon is expanded");
        return this;
    }

    public CloudPage enterSearchQuery(String wordsForCalculatorPageOpening) {
        WebElement textForGoogleSearch = driver.findElement(SEARCH_INPUT);
        textForGoogleSearch.click();
        textForGoogleSearch.sendKeys(wordsForCalculatorPageOpening);
        textForGoogleSearch.sendKeys(Keys.ENTER);
        logger.info("Entered words for searching calculator");
        return this;
    }

    public CloudCalculatorPage openCalculator() {
        driver.findElement(CALCULATOR).click();
        logger.info("Calculator is open");
        return new CloudCalculatorPage(driver);
    }
}
