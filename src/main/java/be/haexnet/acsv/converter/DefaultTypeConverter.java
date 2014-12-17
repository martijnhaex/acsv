package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVConfigurationException;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DefaultTypeConverter implements TypeConverter {

    private static final List<TypeConverter> typeConverters = new ArrayList<TypeConverter>() {{
        add(new BigDecimalConverter());
        add(new BigIntegerConverter());
        add(new BooleanConverter());
        add(new ByteConverter());
        add(new CharacterConverter());
        add(new DoubleConverter());
        add(new FloatConverter());
        add(new IntegerConverter());
        add(new LongConverter());
        add(new ShortConverter());
        add(new StringConverter());
    }};

    private Field field;

    @Override
    public Object apply(final String value) {
        if (field != null && getFieldTypeConverter().isPresent()) {
            return getFieldTypeConverter().get().apply(value);
        }
        throw new ACSVConfigurationException("Converter for exact type is not configured in DefaultTypeConverter.");
    }

    @Override
    public Class appliesFor() {
        return Object.class;
    }

    public void setField(final Field field) {
        this.field = field;
    }

    private Optional<TypeConverter> getFieldTypeConverter() {
        return FluentIterable
                .from(typeConverters)
                .filter(new Predicate<TypeConverter>() {
                    @Override
                    public boolean apply(final TypeConverter typeConverter) {
                        return typeConverter.appliesFor().isAssignableFrom(field.getType());
                    }
                })
                .first();
    }

}
