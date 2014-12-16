package be.haexnet.acsv.converter;

public class StringConverter implements TypeConverter<String> {

    @Override
    public String apply(final String value) {
        return value;
    }

    @Override
    public Class appliesFor() {
        return String.class;
    }

}
