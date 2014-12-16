package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVConfigurationException;
import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.fest.assertions.api.Assertions.assertThat;

public class DefaultTypeConverterTest {

    DefaultTypeConverter converter = new DefaultTypeConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsValueAppliedBySetConverter() {
        converter.setTypeConverter(new BigDecimalConverter());
        assertThat(converter.apply("924.9128384924924593")).isEqualTo(new BigDecimal("924.9128384924924593"));
    }

    @Test
    public void throwsACSVFormatExceptionThrownBySetConverter() throws Exception {
        final String value = "1.1";

        expectedException.expect(ACSVFormatException.class);
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Integer]");

        converter.setTypeConverter(new IntegerConverter());
        converter.apply(value);
    }

    @Test
    public void throwsACSVConfigurationExceptionWhenSetConverterIsNull() throws Exception {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Converter for exact type is not configured in DefaultTypeConverter.");

        converter.apply("82");
    }

}