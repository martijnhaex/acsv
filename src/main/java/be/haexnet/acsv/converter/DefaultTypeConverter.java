package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVConfigurationException;

public class DefaultTypeConverter implements TypeConverter {

    private TypeConverter typeConverter;

    @Override
    public Object apply(final String value) {
        if (typeConverter != null) {
            return typeConverter.apply(value);
        }
        throw new ACSVConfigurationException("Converter for exact type is not configured in DefaultTypeConverter.");
    }

    public void setTypeConverter(final TypeConverter typeConverter) {
        this.typeConverter = typeConverter;
    }
}
