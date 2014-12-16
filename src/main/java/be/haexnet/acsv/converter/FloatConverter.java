package be.haexnet.acsv.converter;

public class FloatConverter extends NumberConverter<Float> {

    @Override
    Float convert(final String value) {
        return Float.valueOf(value);
    }

}
