package be.haexnet.acsv;

import be.haexnet.acsv.annotation.ACSVColumn;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class ACSVParserTest {

    private ACSVParser<Person> parser = new ACSVParser();

    @Test
    public void parseWillReturnEmptyList() throws Exception {
        final List<Person> parsedResult = parser.parse(file("person.csv"), Person.class);
        assertThat(parsedResult).hasSize(2);
        assertThat(extractProperty("firstName").from(parsedResult)).containsOnly("Martijn", "Timo");
        assertThat(extractProperty("lastName").from(parsedResult)).containsOnly("Haex", "Lemmens");
        assertThat(extractProperty("age").from(parsedResult)).containsExactly(24);
    }

    private File file(final String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

    public static class Person {
        @ACSVColumn
        public String firstName;
        @ACSVColumn
        public String lastName;
        @ACSVColumn
        public String age;

        public String getAge() {
            return age;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }
    }

}