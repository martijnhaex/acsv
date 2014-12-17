package be.haexnet.acsv;

import be.haexnet.acsv.data.Employee;
import be.haexnet.acsv.exception.ACSVConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class EmployeeACSVParserIntegrationTest extends ACSVParserIntegrationTest<Employee> {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void parseWillThrowErrorWhenColumnCountCSVIsNotEqualToAnnotatedFieldsCount() {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Headers in CSV file not equal to annotated target fields.");
        parseFile("person.csv", Employee.class);
    }

}
