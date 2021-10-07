package hardcore.tests;

import hardcore.model.Instance;
import hardcore.pages.CloudCalculatorPage;
import hardcore.service.InstanceCreator;
import hardcore.tests.CommonConditions;
import org.testng.annotations.Test;

public class TestCalculatorFilling extends CommonConditions {

    private CloudCalculatorPage fillCalculatorPageWithData() {
        Instance testInstance = InstanceCreator.withCredentialsFromProperty();
        return cloudPage
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
                .pushAddToEstimate();
    }


    @Test
    public void checkInformationInVmClassString() {
        fillCalculatorPageWithData().checkInformationInVmClassIsRegular();
    }

    @Test
    public void checkInformationInInstanceTypeString() {
        fillCalculatorPageWithData().checkInformationInInstanceTypeIncludeN1Standard8();
    }

    @Test
    public void checkRegion() {
        fillCalculatorPageWithData().checkRegionIsFrankfurt();
    }

    @Test
    public void checkLocalSsd() {
        fillCalculatorPageWithData().checkLocalSsdSpace2x375Gib();
    }

    @Test
    public void checkCommitmentTerm() {
        fillCalculatorPageWithData().checkCommitmentTermOneYear();
    }
}
