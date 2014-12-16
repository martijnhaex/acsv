package be.haexnet.acsv.annotation;

import be.haexnet.acsv.converter.DefaultTypeConverter;
import be.haexnet.acsv.converter.TypeConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ACSVColumn {

    Class<? extends TypeConverter> converter() default DefaultTypeConverter.class;

}
