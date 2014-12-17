package be.haexnet.acsv;

import be.haexnet.acsv.data.Country;
import org.junit.Test;

import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class CountryACSVParserIntegrationTest extends ACSVParserIntegrationTest<Country> {

    @Test
    public void canParseWithOwnConverter() {
        final List<Country> parsedResult = parseFile("country.csv", Country.class);
        assertThat(parsedResult).hasSize(4);
        assertThat(extractProperty("iso2Code").from(extractProperty("countryCode").from(parsedResult))).containsOnly("BE", "NL", "DE", "NO");
        assertThat(extractProperty("nameWithSpecialCharacters").from(parsedResult)).containsOnly("België", "Nederland", "Duitsland", "Noorwegen");
        assertThat(extractProperty("nameWithoutSpecialCharacters").from(parsedResult)).containsOnly("Belgie", "Nederland", "Duitsland", "Noorwegen");
    }

}
