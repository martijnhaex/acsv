package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class FloatConverterTest {

    FloatConverter converter = new FloatConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        assertThat(converter.apply("83")).isEqualTo(83.0f);
    }

    @Test
    public void returnsNumberWhenInputIsValidDecimal() {
        assertThat(converter.apply("34.67")).isEqualTo(34.67f);
    }

    @Test
    public void returnsNumberWhenInputIsValidNumberWithF() {
        assertThat(converter.apply("13f")).isEqualTo(13.0f);
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("21o");
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsEmpty() {
        expectACSVFormatException("");
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsNull() {
        expectACSVFormatException(null);
    }

    @Test
    public void appliesForFloat() {
        assertThat(converter.appliesFor()).isEqualTo(Float.class);
    }

    private void expectACSVFormatException(final String value) {
        expectedException.expect(ACSVFormatException.class);
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Float]");

        converter.apply(value);
    }

}