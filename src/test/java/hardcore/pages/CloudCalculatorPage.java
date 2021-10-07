package hardcore.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CloudCalculatorPage extends BasePage {

    private final By FIRST_FRAME = By.xpath("//iframe[contains(@name,'goog_')]");
    private final By INSTANCES_FIELD = By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']");
    private final By MACHINE_SERIES = By.xpath("//md-select[@id='select_96']");
    private final By MACHINE_SERIES_MODEL = By.xpath("//md-option[@id='select_option_208']");
    private final By MACHINE_TYPE = By.xpath("//md-select[@placeholder='Instance type']");
    private final By MACHINE_TYPE_N1_STANDARD_8 = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private final By GPU_CHECKBOX = By.xpath("//md-checkbox[@aria-label='Add GPUs']");
    private final By NUMBER_OF_GPU = By.xpath("//md-select[@placeholder='Number of GPUs']");
    private final By NUMBER_OF_GPU_MODEL = By.xpath("//md-option[@id='select_option_443']");
    private final By GPU_TYPE = By.xpath("//md-select[@placeholder='GPU type']");
    private final By GPU_TYPE_MODEL = By.xpath("//md-option[@value='NVIDIA_TESLA_V100']");
    private final By LOCAL_SSD = By.xpath("//md-select[@placeholder='Local SSD']");
    private final By LOCAL_SSD_MODEL = By.xpath("//md-option[@id='select_option_425']");
    private final By DATA_CENTER_LOCATION = By.xpath("//md-select[@placeholder='Datacenter location']");
    private final By DATA_CENTER_LOCATION_FRANKFURT = By.xpath("//md-select-menu[@class='md-overflow']/child::md-content/child::md-optgroup/child::md-option[@value='europe-west3']/child::div");
    private final By COMMITTED_USAGE = By.xpath("//md-select[@placeholder='Committed usage']");
    private final By ONE_YEAR_USAGE = By.xpath("//md-option[@id='select_option_106']");
    private final By ADD_TO_ESTIMATE_BUTTON = By.xpath("//button[@aria-label='Add to Estimate']");
    private final By EMAIL_ESTIMATE_BUTTON = By.xpath("//button[@aria-label='Email Estimate']");
    private final By COST_OF_CALCULATOR = By.xpath("//div[@class='md-list-item-text']/child::b[@class ='ng-binding']");
    private final By INFORMATION_IN_VM_CLASS_IS_REGULAR = By.xpath("//div[contains (text(),'VM class: regular')]");
    private final By INFORMATION_IN_INSTANCE_TYPE_INCLUDE_N1STANDARD8 = By.xpath("//div[contains (text(),'Instance type: n1-standard-8')]");
    private final By REGION_IS_FRANKFURT = By.xpath("//div[contains (text(),'Region: Frankfurt')]");
    private final By LOCAL_SSD_SPACE_2X375GIB = By.xpath("//*[@id='compute']/md-list/md-list-item[8]/div[1]");
    private final By COMMITMENT_TERM_ONE_YEAR = By.xpath("//div[contains (text(),'Commitment term: 1 Year')]");
    private final By FIRST_NAME = By.xpath("//input[@ng-model='emailQuote.user.firstname']");
    private final By LAST_NAME = By.xpath("//input[@ng-model='emailQuote.user.lastname']");
    private final By EMAIL_FIELD = By.xpath("//input[@type='email']");
    private final By SEND_BUTTON = By.xpath("//button[@aria-label='Send Email']");
    private String textFromCalculator;

    private EmailPage emailPage;
    private final Logger logger = LogManager.getRootLogger();

    private List<String> tabs;

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudCalculatorPage fillNumberOfInstances(String keyForNumberOfInstances) {
        WebElement element = driver.findElement(FIRST_FRAME);
        driver.switchTo().frame(element);
        driver.switchTo().frame("myFrame");
        logger.info("Switched to frame");
        WebElement numberOfInstancesField = driver.findElement(INSTANCES_FIELD);
        numberOfInstancesField.sendKeys(keyForNumberOfInstances);
        logger.info("Instance Field is filled by number 4");
        return this;
    }

    public CloudCalculatorPage selectMachineSeries() {
        WebElement element1 = driver.findElement(MACHINE_SERIES);
        element1.click();
        WebElement element2 = driver.findElement(MACHINE_SERIES_MODEL);
        element2.sendKeys(Keys.ENTER);
        logger.info("Machine Series N1 is selected");
        return this;
    }

    public CloudCalculatorPage selectMachineType() {
        WebElement element3 = driver.findElement(MACHINE_TYPE);
        element3.click();
        WebElement element4 = driver.findElement(MACHINE_TYPE_N1_STANDARD_8);
        element4.sendKeys(Keys.ENTER);
        logger.info("Machine type N1_STANDARD_8 is selected");
        return this;
    }

    public CloudCalculatorPage clickAddGpusCheckBox() {
        clickElement(GPU_CHECKBOX);
        logger.info("Gpu checkbox is open");
        return this;
    }

    private void clickElement(By element) {
        driver.findElement(element).click();
    }

    public CloudCalculatorPage selectNumberOfGpus() {
        driver.findElement(NUMBER_OF_GPU).click();
        driver.findElement(NUMBER_OF_GPU_MODEL).click();
        logger.info("Number of gpu is selected");
        return this;
    }

    public CloudCalculatorPage selectGpuType() {
        driver.findElement(GPU_TYPE).click();
        driver.findElement(GPU_TYPE_MODEL).click();
        logger.info("Type of gpu is selected");
        return this;
    }

    public CloudCalculatorPage selectLocalSsd() {
        driver.findElement(LOCAL_SSD).click();
        driver.findElement(LOCAL_SSD_MODEL).sendKeys(Keys.ENTER);
        logger.info("Local SSD is selected");
        return this;
    }

    public CloudCalculatorPage selectDataCenterLocation() {
        driver.findElement(DATA_CENTER_LOCATION).click();
        WebElement element = driver.findElement(By.xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']/child::md-select-menu/child::md-content/child::md-select-header/child::md-input-container/child::input[@aria-label='Search region']"));
        element.click();
        element.sendKeys("Frankfurt");
        driver.findElement(DATA_CENTER_LOCATION_FRANKFURT).click();
        logger.info("Data Center Location Frankfurt is selected");
        return this;
    }

    public CloudCalculatorPage selectCommittedUsage() {
        driver.findElement(COMMITTED_USAGE).click();
        driver.findElement(ONE_YEAR_USAGE).click();
        logger.info("Committed Usage 1 year  is selected");
        return this;
    }

    public CloudCalculatorPage pushAddToEstimate() {
        logger.info("Chose all instances");
        driver.findElement(ADD_TO_ESTIMATE_BUTTON).click();
        logger.info("The price was estimated");
        saveTextFromCalculator(driver.findElement(COST_OF_CALCULATOR).getText());
        logger.info("Cost was saved");
        driver.findElement(EMAIL_ESTIMATE_BUTTON).click();
        logger.info("The field Email estimate is open");
        return this;
    }

    private void saveTextFromCalculator(String textFromCalculator) {
        this.textFromCalculator = textFromCalculator;
    }

    public String getTextFromCalculator() {
        return textFromCalculator;
    }

    private void resetTextFromCalculator() {
        this.textFromCalculator = null;
    }

    public EmailPage openEmailPage() {
        if (emailPage == null) {
            driver.getWindowHandle();
            ((JavascriptExecutor) driver).executeScript("window.open()");
            initTabs();
            driver.switchTo().window(tabs.get(1));
            driver.get("https://yopmail.com/");
            driver.getWindowHandle();
            logger.info("New tab 'yopmail' is open");
            emailPage = new EmailPage(driver, tabs, this);
        } else {
            driver.switchTo().window(tabs.get(1));
            logger.info("tab 'yopmail' is open");
        }
        return emailPage;
    }

    private void initTabs() {
        tabs = new ArrayList<>(driver.getWindowHandles());
    }

    public CloudCalculatorPage fillFirstName(String nameFirst) {
        WebElement firstNameField = driver.findElement(FIRST_NAME);
        firstNameField.click();
        firstNameField.sendKeys(nameFirst);
        logger.info("First name is filled");
        return this;
    }

    public CloudCalculatorPage fillSurname(String nameLast) {
        WebElement lastNameFields = driver.findElement(LAST_NAME);
        lastNameFields.click();
        lastNameFields.sendKeys(nameLast);
        logger.info("Last name is filled");
        return this;
    }

    public CloudCalculatorPage fillEmailForm() {
        driver.findElement(EMAIL_FIELD).click();
        Actions actions = new Actions(driver);
        Action keyDown = actions.keyDown(Keys.LEFT_CONTROL).sendKeys("v").build();
        keyDown.perform();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        logger.info("Email is filled");
        return this;
    }

    public CloudCalculatorPage clickSendButton() {
        driver.findElement(SEND_BUTTON).click();
        logger.info("Email is sent");
        return this;
    }

    public void checkInformationInVmClassIsRegular() {
        try {
            driver.findElement(INFORMATION_IN_VM_CLASS_IS_REGULAR);
            logger.info("Element with information about VM Class is found ");
        } catch (NoSuchElementException e) {
            logger.error("Element with information about VM Class is Not found ");
            throw e;
        }
    }

    public void checkInformationInInstanceTypeIncludeN1Standard8() {
        try {
            driver.findElement(INFORMATION_IN_INSTANCE_TYPE_INCLUDE_N1STANDARD8);
            logger.info("Element with information about Instance Type Includes N1Standard8 is found ");
        } catch (NoSuchElementException e) {
            logger.error("Element with information about Instance Type Includes N1Standard8 is not found ");
            throw e;
        }
    }

    public void checkRegionIsFrankfurt() {
        try {
            driver.findElement(REGION_IS_FRANKFURT);
            logger.info("Element with information about center location is Frankfurt  is found ");
        } catch (NoSuchElementException e) {
            logger.error("Element with information about center location is  Frankfurt is not found ");
            throw e;
        }
    }

    public void checkLocalSsdSpace2x375Gib() {
        try {
            driver.findElement(LOCAL_SSD_SPACE_2X375GIB);
            logger.info("Element with information about local ssd is 2x375Gib is found ");
        } catch (NoSuchElementException e) {
            logger.error("Element with information about local ssd is 2x375Gib is not found ");
            throw e;
        }
    }

    public void checkCommitmentTermOneYear() {
        try {
            driver.findElement(COMMITMENT_TERM_ONE_YEAR);
            logger.info("Element with information about commitment term one year is found ");
        } catch (NoSuchElementException e) {
            logger.error("Element with information about commitment term one year is not found ");
            throw e;
        }
    }
}
