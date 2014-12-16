package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.apache.commons.lang3.math.NumberUtils;

public class IntegerConverter implements TypeConverter<Integer> {

    @Override
    public Integer apply(final String value) {
        if (NumberUtils.isNumber(value)) {
            return Integer.valueOf(value);
        }
        throw new ACSVFormatException(value, Integer.class.getName());
    }

}
