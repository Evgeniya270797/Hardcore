package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class CalculatorPage extends BasePage {

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private By searchIcon = By.className("devsite-search-form");
    private By searchInput = By.xpath("//input[@class='devsite-search-field devsite-search-query']");
    private By switchToCalculator = By.linkText("Google Cloud Platform Pricing Calculator");
    private By newFirstFrame = By.xpath("//iframe[contains(@name,'goog_')]");
    private By instancesField =
            By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']");
    private By seriesOfMachine = By.xpath("//md-select[@id='select_96']");
    private By seriesOfMachineModel = By.xpath("//md-option[@id='select_option_208']");
    private By machineType = By.xpath("//md-select[@placeholder='Instance type']");
    private By computeEngine = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private By gpusCheckBox = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private By numberOfGpus = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private By numberOfGpusModel = By.xpath("//md-option[@id='select_option_443']");
    private By gpuType = By.xpath("//md-select[@placeholder='GPU type']");
    private By gpuTypeModel = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private By localSsd = By.xpath("//md-select[@placeholder='Local SSD']");
    private By localSsdModel = By.xpath("//md-option[@id='select_option_425']");
    private By dataCenterLocation = By.xpath("//md-select[@placeholder='Datacenter location']");
    private By dataCenterLocationInFrankfurt = By.xpath("//md-select-menu[@class='md-overflow']/child::md-content/child::md-optgroup/child::md-option[@value='europe-west3']/child::div");
    private By committedUsage = By.xpath("//md-select[@placeholder='Committed usage']");
    private By oneYearUsage = By.xpath("//md-option[@id='select_option_106']");
    private By addToEstimateButton = By.xpath("//button[@aria-label='Add to Estimate']");
    private By emailEstimateButton = By.xpath("//button[@aria-label='Email Estimate']");
    private By linkToGetAnEmail = By.xpath("//a[@href='email-generator']");
    private By buttonToCopyEmail = By.xpath("//button[@id='cprnd']");
    private By costOfCalculator = By.xpath("//div[@class='md-list-item-text']/child::b[@class ='ng-binding']");
    private By emailField = By.xpath("//input[@type='email']");
    private By sendButton = By.xpath("//button[@aria-label='Send Email']");
    private By mailButton = By.xpath("/html/body/div/div[2]/main/div/div[2]/div/div/div[2]/button[2]");
    private By refreshButton = By.xpath("//button[@id='refresh']");
    private By firstName = By.xpath("//input[@ng-model='emailQuote.user.firstname']");
    private By lastName = By.xpath("//input[@ng-model='emailQuote.user.lastname']");
    private By informationInVmClassIsRegular = By.xpath("//div[contains (text(),'VM class: regular')]");
    private By InformationInInstanceTypeIncludeN1Standard8 = By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    private By regionIsFrankfurt = By.xpath("//div[contains (text(),'Region: Frankfurt')]");
    private By localSsdSpace2x375Gib = By.xpath("//*[@id='compute']/md-list/md-list-item[8]/div[1]");
    private By commitmentTermOneYear = By.xpath("//div[contains (text(),'Commitment term: 1 Year')]");
    String textFromCalculator;
    private final Logger logger = LogManager.getRootLogger();

    public void openCloudPage() {
        driver.get("https://cloud.google.com/");
        logger.info("Cloud page is open");
    }

    public void goToGoogleCloudPlatformPricingCalculatorPage(String wordsForCalculatorPageOpening) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchIcon));
        driver.findElement(searchIcon).click();
        WebElement textForGoogleSearch = driver.findElement(searchInput);
        textForGoogleSearch.click();
        textForGoogleSearch.sendKeys(wordsForCalculatorPageOpening);
        textForGoogleSearch.sendKeys(Keys.ENTER);
        driver.findElement(switchToCalculator).click();
        logger.info("Calculator was opened");
    }

    public void sendKeyInToNumberOfInstancesField(String keyForNumberOfInstances) {;
        WebElement element = driver.findElement(newFirstFrame);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        WebElement numberOfInstancesField = driver.findElement(instancesField);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
        logger.info("Instance Field is filled by number 4");
    }

    public void selectSeriesOfMachine() {
        WebElement element1 = driver.findElement(seriesOfMachine);
        element1.click();
        WebElement element2 = driver.findElement(seriesOfMachineModel);
        element2.sendKeys(Keys.ENTER);
        logger.info("Machine series ");
    }

    public void selectMachineType() {
        WebElement element3 = driver.findElement(machineType);
        element3.click();
        WebElement element4 = driver.findElement(computeEngine);
        element4.sendKeys(Keys.ENTER);
    }

    public void clickAddGpusCheckBox() {
        driver.findElement(gpusCheckBox).click();
    }

    public void selectNumberOfGpus() {
        driver.findElement(numberOfGpus).click();
        driver.findElement(numberOfGpusModel).click();
    }

    public void selectGpuType() {
        driver.findElement(gpuType).click();
        driver.findElement(gpuTypeModel).click();
    }

    public void selectLocalSsd() {
        driver.findElement(localSsd).click();
        driver.findElement(localSsdModel).sendKeys(Keys.ENTER);
    }

    public void selectDataCenterLocation() {
        driver.findElement(dataCenterLocation).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']/child::md-select-menu/child::md-content/child::md-select-header/child::md-input-container/child::input[@aria-label='Search region']"));
        element.click();
        element.sendKeys("Frankfurt");
        driver.findElement(dataCenterLocationInFrankfurt).click();
    }

    public void selectCommittedUsage() {
        driver.findElement(committedUsage).click();
        driver.findElement(oneYearUsage).click();
    }

    public void pushAddToEstimate() {
        logger.info("Chose all instances");
        driver.findElement(addToEstimateButton).click();
        textFromCalculator = driver.findElement(costOfCalculator).getText();
        driver.findElement(emailEstimateButton).click();
    }

    public Boolean checkTheMessageWithThePrice(String nameFirst,String nameLast) {
        String calculatorWindow = driver.getWindowHandle();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        driver.get("https://yopmail.com/");
        String mailWindow = driver.getWindowHandle();
        driver.findElement(linkToGetAnEmail).click();
        driver.findElement(buttonToCopyEmail).click();

        driver.switchTo().window(tabs.get(0));
        WebElement elementIframe = driver.findElements(By.tagName("iframe")).get(0);
        driver.switchTo().frame(elementIframe);
        driver.switchTo().frame("myFrame");
        WebElement firstNameField = driver.findElement(firstName);
        firstNameField.click();
        firstNameField.sendKeys(nameFirst);
        WebElement lastNameFields = driver.findElement(lastName);
        lastNameFields.click();
        lastNameFields.sendKeys(nameLast);
        driver.findElement(emailField).click();
        Actions actions = new Actions(driver);
        Action keyDown = actions.keyDown(Keys.LEFT_CONTROL).sendKeys("v").build();
        keyDown.perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(sendButton).click();
        driver.switchTo().window(tabs.get(1));
        driver.findElement(mailButton).click();
        driver.findElement(refreshButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifmail")));
        driver.switchTo().frame(driver.findElement(By.id("ifmail")));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td/h3[contains(text(),'USD')]")));
        WebElement text = driver.findElement(By.xpath("//td/h3[contains(text(),'USD')]"));
        logger.info("We have got email");
        String textFromMail = text.getText();
        return textFromCalculator.contains(textFromMail);
    }


    public void checkInformationInVmClassIsRegular() {
        driver.findElement(informationInVmClassIsRegular);
    }

    public void checkInformationInInstanceTypeIncludeN1Standard8() {
        driver.findElement(InformationInInstanceTypeIncludeN1Standard8);
    }

    public void checkRegionIsFrankfurt() {
        driver.findElement(regionIsFrankfurt);
    }

    public void checkLocalSsdSpace2x375Gib() {
        driver.findElement(localSsdSpace2x375Gib);
    }

    public void checkCommitmentTermOneYear() {
        driver.findElement(commitmentTermOneYear);
    }
}
