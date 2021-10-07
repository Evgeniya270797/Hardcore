package hardcore.tests;

import hardcore.model.Instance;
import hardcore.service.InstanceCreator;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import hardcore.pages.CalculatorPage;

public class PageTests  extends CommonConditions{
    @Ignore
    @Test
    public void checkTheSentMessageWithThePrice() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        calculatorPage.openCloudPage();
        calculatorPage.goToGoogleCloudPlatformPricingCalculatorPage(
                testInstance.getTextCalculator());
        calculatorPage.sendKeyInToNumberOfInstancesField(testInstance.getNumberOfInstancesField());
        calculatorPage.selectSeriesOfMachine();
        calculatorPage.selectMachineType();
        calculatorPage.clickAddGpusCheckBox();
        calculatorPage.selectNumberOfGpus();
        calculatorPage.selectGpuType();
        calculatorPage.selectLocalSsd();
        calculatorPage.selectDataCenterLocation();
        calculatorPage.selectCommittedUsage();
        calculatorPage.pushAddToEstimate();
        boolean result = calculatorPage.checkTheMessageWithThePrice(testInstance.getFirstName(), testInstance.getLastName());
        Assert.assertTrue(result);
    }
}

