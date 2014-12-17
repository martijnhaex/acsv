package be.haexnet.acsv;

import be.haexnet.acsv.data.Embryo;
import be.haexnet.acsv.data.Employee;
import be.haexnet.acsv.data.Person;
import be.haexnet.acsv.exception.ACSVConfigurationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class PersonACSVParserIntegrationTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ACSVParser<Person> parser = new ACSVParser();

    @Test
    public void parseWillReturnExpectedResult() throws Exception {
        final List<Person> parsedResult = parser.parse(file("person.csv"), Person.class);
        assertThat(parsedResult).hasSize(2);
        assertThat(extractProperty("firstName").from(parsedResult)).containsOnly("Martijn", "Timo");
        assertThat(extractProperty("lastName").from(parsedResult)).containsOnly("Haex", "Lemmens");
        assertThat(extractProperty("age").from(parsedResult)).containsOnly(24);
    }

    @Test
    public void parseWillThrowErrorWhenColumnCountCSVIsNotEqualToAnnotatedFieldsCount() throws Exception {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Headers in CSV file not equal to annotated target fields.");
        parser.parse(file("person.csv"), Employee.class);
    }

    @Test
    public void parseWillThrowErrorWhenColumnHeadersIsNotFoundAsAnnotatedField() throws Exception {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Not expecting header found: age.");
        parser.parse(file("person.csv"), Embryo.class);
    }

    private File file(final String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

}