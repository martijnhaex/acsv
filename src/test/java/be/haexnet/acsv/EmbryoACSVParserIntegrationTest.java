package be.haexnet.acsv;

import be.haexnet.acsv.data.Embryo;
import be.haexnet.acsv.exception.ACSVConfigurationException;
import be.haexnet.acsv.exception.ACSVInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class EmbryoACSVParserIntegrationTest extends ACSVParserIntegrationTest<Embryo> {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void canParseWillThrowErrorWhenColumnHeadersIsNotFoundAsAnnotatedField() {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Not expecting header found: age.");
        parseFile("person.csv", Embryo.class);
    }

    @Test
    public void canParseNonStringFieldCorrectly() {
        final List<Embryo> parsedResult = parseFile("embryo.csv", Embryo.class);
        assertThat(parsedResult).hasSize(3);
        assertThat(extractProperty("firstName").from(parsedResult)).containsOnly("Mayra", "Bram", "Lore");
        assertThat(extractProperty("lastName").from(parsedResult)).containsOnly("Schrooten", "Thijs", "Vandewaerde");
        assertThat(extractProperty("gender").from(parsedResult)).containsOnly('M', 'V');
    }

    @Test
    public void canParseEmptyFileOnlyHeadersWillReturnEmptyList() {
        assertThat(parseFile("empty_embryo.csv", Embryo.class)).isEmpty();
    }

    @Test
    public void canParseEmptyFile() {
        expectedException.expect(ACSVInputException.class);
        expectedException.expectMessage("Empty CSV File, can not parse.");
        parseFile("empty.csv", Embryo.class);
    }

}
