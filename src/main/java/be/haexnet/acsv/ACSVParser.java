package be.haexnet.acsv;

import au.com.bytecode.opencsv.CSV;
import au.com.bytecode.opencsv.CSVReadProc;
import be.haexnet.acsv.annotation.ACSVColumn;
import be.haexnet.acsv.util.AnnotationUtil;
import be.haexnet.acsv.util.ReflectionUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ACSVParser<Entity> {

    public List<Entity> parse(final File file, final Class targetClass) {
        final List<String[]> rows = getAllRowsFromFile(file);
        final String[] rawHeader = extractRawHeader(rows);
        final List<String[]> rawData = extractRawData(rows);

        final List<Entity> parsedResult = new ArrayList<>();
        for (final String[] rawDataLine : rawData) {
            final Entity newInstance = (Entity) ReflectionUtil.createNewInstanceFor(targetClass);

            for (final Field declaredField : AnnotationUtil.getAnnotatedFieldsOf(newInstance, ACSVColumn.class)) {
                if (declaredField.isAnnotationPresent(ACSVColumn.class)) {
                    final String declaredFieldName = declaredField.getName();

                    for (int i = 0; i < rawHeader.length; i++) {
                        if (rawHeader[i].equals(declaredFieldName)) {
                            ReflectionUtil.setFieldValue(newInstance, declaredField, rawDataLine[i]);
                            break;
                        }
                    }
                }
            }
            parsedResult.add(newInstance);
        }
        return parsedResult;
    }

    private List<String[]> getAllRowsFromFile(final File file) {
        final List<String[]> rows = new ArrayList<>();
        CSV.separator(',').create().read(file, new CSVReadProc() {
            @Override
            public void procRow(int i, String... strings) {
                rows.add(strings);
            }
        });
        return rows;
    }

    private String[] extractRawHeader(final List<String[]> rows) {
        return rows.get(0);
    }

    private List<String[]> extractRawData(final List<String[]> rows) {
        return rows.subList(1, rows.size());
    }

}
