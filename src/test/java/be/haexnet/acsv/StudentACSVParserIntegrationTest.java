package be.haexnet.acsv;

import be.haexnet.acsv.data.Student;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class StudentACSVParserIntegrationTest extends ACSVParserIntegrationTest<Student> {

    @Test
    public void canParseWithEntityFieldNameDifferentFromCSVHeaders() {
        final List<Student> parsedResult = parseFile("student.csv", Student.class);
        assertThat(parsedResult).hasSize(1);
        assertThat(extractProperty("givenName").from(parsedResult)).containsExactly("Timo");
        assertThat(extractProperty("familyName").from(parsedResult)).containsExactly("Lemmens");
        assertThat(extractProperty("schoolName").from(parsedResult)).containsExactly("UA");
        assertThat(extractProperty("fieldOfStudy").from(parsedResult)).containsExactly("Political Science");
    }

}
