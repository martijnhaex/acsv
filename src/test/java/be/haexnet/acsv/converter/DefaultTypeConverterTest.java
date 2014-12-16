package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVConfigurationException;
import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class DefaultTypeConverterTest {

    DefaultTypeConverter converter = new DefaultTypeConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsValueAppliedBySetConverter() throws NoSuchFieldException {
        converter.setField(Task.class.getDeclaredField("done"));
        assertThat(converter.apply("t")).isEqualTo(true);
    }

    @Test
    public void throwsACSVFormatExceptionThrownBySetConverter() throws NoSuchFieldException {
        final String value = "1.1";

        expectedException.expect(ACSVFormatException.class);
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Integer]");

        converter.setField(Task.class.getDeclaredField("pages"));
        converter.apply(value);
    }

    @Test
    public void throwsACSVConfigurationExceptionWhenSetConverterIsNull() {
        expectedException.expect(ACSVConfigurationException.class);
        expectedException.expectMessage("Converter for exact type is not configured in DefaultTypeConverter.");

        converter.apply("82");
    }

    @Test
    public void appliesForObject() {
        assertThat(converter.appliesFor()).isEqualTo(Object.class);
    }

    protected static class Task {
        private Boolean done;
        private Integer pages;
    }

}