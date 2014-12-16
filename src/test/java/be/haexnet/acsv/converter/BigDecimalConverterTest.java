package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

import static org.fest.assertions.api.Assertions.assertThat;

public class BigDecimalConverterTest {

    BigDecimalConverter converter = new BigDecimalConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        assertThat(converter.apply("82")).isEqualTo(new BigDecimal("82"));
    }

    @Test
    public void returnsNumberWhenInputIsValidDecimalNumber() {
        assertThat(converter.apply("34.091")).isEqualTo(new BigDecimal("34.091"));
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("0.91p");
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
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.math.BigDecimal]");

        converter.apply(value);
    }

}