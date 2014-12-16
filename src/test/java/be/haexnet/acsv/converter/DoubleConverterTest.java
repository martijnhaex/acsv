package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class DoubleConverterTest {

    DoubleConverter converter = new DoubleConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        assertThat(converter.apply("14")).isEqualTo(14.0);
    }

    @Test
    public void returnsNumberWhenInputIsValidDecimal() {
        assertThat(converter.apply("98.721")).isEqualTo(98.721);
    }

    @Test
    public void returnsNumberWhenInputIsValidNumberWithD() {
        assertThat(converter.apply("1d")).isEqualTo(1.0);
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("28b");
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsEmpty() {
        expectACSVFormatException("");
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsNull() {
        expectACSVFormatException(null);
    }

    private void expectACSVFormatException(final String value) {
        expectedException.expect(ACSVFormatException.class);
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Double]");

        converter.apply(value);
    }

}