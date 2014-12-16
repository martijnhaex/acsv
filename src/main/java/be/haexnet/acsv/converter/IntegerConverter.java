package be.haexnet.acsv.converter;

public class IntegerConverter extends NumberConverter<Integer> {

    @Override
    Integer convert(final String value) {
        return Integer.valueOf(value);
    }

    @Override
    public Class appliesFor() {
        return Integer.class;
    }

}
