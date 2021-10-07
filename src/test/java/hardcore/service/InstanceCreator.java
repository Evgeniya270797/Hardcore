package hardcore.service;
import hardcore.model.Instance;

public class InstanceCreator {
    public static final String TESTADATA_TEXT_CALCULATOR = "testdata.text.calculator";
    public static final String TESTADATA_INSTANCE_NUMBER = "testdata.instance.number";
    public static final String TESTADATA_FIRST_NAME = "testdata.first.name";
    public static final String TESTADATA_LAST_NAME = "testdata.last.name";


    public static Instance withCredentialsFromProperty() {
        return new Instance(TestDataReader.getTestData(TESTADATA_TEXT_CALCULATOR),
                TestDataReader.getTestData(TESTADATA_INSTANCE_NUMBER),
                TestDataReader.getTestData(TESTADATA_FIRST_NAME),
                TestDataReader.getTestData(TESTADATA_LAST_NAME));
    }
}