package be.haexnet.acsv;

import be.haexnet.acsv.data.Person;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class PersonACSVParserIntegrationTest extends ACSVParserIntegrationTest<Person> {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canParseWillReturnExpectedResult() {
        final List<Person> parsedResult = parseFile("person.csv", Person.class);
        assertThat(parsedResult).hasSize(2);
        assertThat(extractProperty("firstName").from(parsedResult)).containsOnly("Martijn", "Timo");
        assertThat(extractProperty("lastName").from(parsedResult)).containsOnly("Haex", "Lemmens");
        assertThat(extractProperty("age").from(parsedResult)).containsOnly(24);
    }

}