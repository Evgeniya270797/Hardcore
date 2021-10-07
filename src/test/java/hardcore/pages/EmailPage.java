package hardcore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class EmailPage extends BasePage{

    private final By LINK_TO_GET_EMAIL = By.xpath("//a[@href='email-generator']");
    private final By BUTTON_TO_COPY_EMAIL = By.xpath("//button[@id='cprnd']");
    private final By MAIL_BUTTON = By.xpath("/html/body/div/div[2]/main/div/div[2]/div/div/div[2]/button[2]");
    private final By REFRESH_BUTTON = By.xpath("//button[@id='refresh']");

    private final List<String> tabs;
    private final CloudCalculatorPage calculatorPage;
    WebDriverWait wait = new WebDriverWait(driver, 30);
    String textFromMail;

    public EmailPage(WebDriver driver,
                     List<String> tabs,
                     CloudCalculatorPage calculatorPage) {
        super(driver);
        this.tabs = tabs;
        this.calculatorPage = calculatorPage;
    }

    public EmailPage getAnEmail() {
        driver.findElement(LINK_TO_GET_EMAIL).click();
        return this;
    }

    public EmailPage copyEmail() {
        driver.findElement(BUTTON_TO_COPY_EMAIL).click();
        logger.info("email is copied");
        return this;
    }

    public CloudCalculatorPage switchToCalculatorPage() {
        driver.switchTo().window(tabs.get(0));
        WebElement elementIframe = driver.findElements(By.tagName("iframe")).get(0);
        driver.switchTo().frame(elementIframe);
        driver.switchTo().frame("myFrame");
        logger.info("Calculator page is open");
        return calculatorPage;
    }

    public EmailPage clickMailButton(){
        driver.findElement(MAIL_BUTTON).click();
        logger.info("Main button is clicked");
        return this;
    }

    public EmailPage clickRefreshButton(){
        do{
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.findElement(REFRESH_BUTTON).click();
            logger.info("Refresh button is clicked");
        }while(driver.findElement(By.id("ifmail")).isDisplayed());
        return this;
    }

    public EmailPage switchToFrame(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifmail")));
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));
        return this;
    }


    public EmailPage getTextFromEmail(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/h3[contains(text(),'USD')]")));
        WebElement text = driver.findElement(By.xpath("//td/h3[contains(text(),'USD')]"));
        textFromMail = text.getText();
        logger.info("Text from email is retrieved");
        return this;
    }

    public boolean checkPriceFromEmailAndCalculator(){
        logger.info("Сhecking the price in the email and in the calculator");
        return calculatorPage.getTextFromCalculator().contains(textFromMail);
    }

}
