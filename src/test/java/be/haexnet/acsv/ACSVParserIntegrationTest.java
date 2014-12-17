package be.haexnet.acsv;

import java.io.File;
import java.util.List;

public abstract class ACSVParserIntegrationTest<Entity> {

    private ACSVParser<Entity> parser = new ACSVParser();

    protected List<Entity> parseFile(final String fileName, final Class<Entity> entityClass) {
        return parser.parse(file(fileName), entityClass);
    }

    private File file(final String fileName) {
        final ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }

}
