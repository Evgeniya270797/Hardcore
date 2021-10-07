package hardcore.tests;

import hardcore.model.Instance;
import hardcore.service.InstanceCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPrice extends CommonConditions {

    @Test
    public void checkTheSentMessageWithThePrice() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        boolean result = cloudPage
                .openPage()
                .expandSearch()
                .enterSearchQuery(testInstance.getTextCalculator())
                .openCalculator()
                .fillNumberOfInstances(testInstance.getNumberOfInstancesField())
                .selectMachineSeries()
                .selectMachineType()
                .clickAddGpusCheckBox()
                .selectNumberOfGpus()
                .selectGpuType()
                .selectLocalSsd()
                .selectDataCenterLocation()
                .selectCommittedUsage()
                .pushAddToEstimate()
                .openEmailPage()
                .getAnEmail()
                .copyEmail()
                .switchToCalculatorPage()
                .fillFirstName(testInstance.getFirstName())
                .fillSurname(testInstance.getLastName())
                .fillEmailForm()
                .clickSendButton()
                .openEmailPage()
                .clickMailButton()
                .clickRefreshButton()
                .switchToFrame()
                .getTextFromEmail()
                .checkPriceFromEmailAndCalculator();
        Assert.assertTrue(result);
    }
}

