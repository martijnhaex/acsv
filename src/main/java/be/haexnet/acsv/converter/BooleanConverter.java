package be.haexnet.acsv.converter;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class BooleanConverter implements TypeConverter<Boolean> {

    @Override
    public Boolean apply(final String value) {
        if (NumberUtils.isNumber(value)) {
            return BooleanUtils.toBoolean(Integer.valueOf(value));
        }
        return BooleanUtils.toBoolean(value);
    }

}
