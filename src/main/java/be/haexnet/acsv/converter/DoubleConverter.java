package be.haexnet.acsv.converter;

public class DoubleConverter extends NumberConverter<Double> {

    @Override
    Double convert(final String value) {
        return Double.valueOf(value);
    }

}
