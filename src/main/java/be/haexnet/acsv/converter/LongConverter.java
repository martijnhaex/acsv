package be.haexnet.acsv.converter;

public class LongConverter extends NumberConverter<Long> {

    @Override
    Long convert(final String value) {
        return Long.valueOf(value);
    }

    @Override
    public Class appliesFor() {
        return Long.class;
    }

}
