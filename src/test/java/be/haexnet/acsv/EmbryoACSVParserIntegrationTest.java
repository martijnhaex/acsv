package be.haexnet.acsv;

import be.haexnet.acsv.data.Embryo;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class EmbryoACSVParserIntegrationTest {

    private ACSVParser<Embryo> parser = new ACSVParser();

    @Test
    public void canParseNonStringFieldCorrectly() throws Exception {
        final List<Embryo> parsedResult = parser.parse(file("embryo.csv"), Embryo.class);
        assertThat(parsedResult).hasSize(3);
        assertThat(extractProperty("firstName").from(parsedResult)).containsOnly("Mayra", "Bram", "Lore");
        assertThat(extractProperty("lastName").from(parsedResult)).containsOnly("Schrooten", "Thijs", "Vandewaerde");
        assertThat(extractProperty("gender").from(parsedResult)).containsOnly('M', 'V');
    }

    private File file(final String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

}
