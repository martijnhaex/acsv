package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class ByteConverterTest {

    ByteConverter converter = new ByteConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        final Byte expectedValue = 2;
        assertThat(converter.apply("2")).isEqualTo(expectedValue);
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("1b");
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
    public void appliesForByte() {
        assertThat(converter.appliesFor()).isEqualTo(Byte.class);
    }

    private void expectACSVFormatException(final String value) {
        expectedException.expect(ACSVFormatException.class);
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Byte]");

        converter.apply(value);
    }

}