package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.ParameterizedType;

public abstract class NumberConverter<Type> implements TypeConverter<Type> {

    @Override
    public Type apply(final String value) {
        try {
            if (NumberUtils.isNumber(value)) {
                return convert(value);
            }
            throw new ACSVFormatException(value, getClassFromTypeParameter());
        } catch (NumberFormatException e) {
            throw new ACSVFormatException(value, getClassFromTypeParameter());
        }
    }

    abstract Type convert(String value);

    private Class getClassFromTypeParameter() {
        return (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
