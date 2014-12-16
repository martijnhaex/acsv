package be.haexnet.acsv.converter;

public class ShortConverter extends NumberConverter<Short> {

    @Override
    Short convert(final String value) {
        return Short.valueOf(value);
    }

}
