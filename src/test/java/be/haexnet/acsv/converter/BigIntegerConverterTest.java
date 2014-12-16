package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigInteger;

import static org.fest.assertions.api.Assertions.assertThat;

public class BigIntegerConverterTest {

    BigIntegerConverter converter = new BigIntegerConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        assertThat(converter.apply("921455")).isEqualTo(new BigInteger("921455"));
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsDecimalNumber() {
        expectACSVFormatException("13.2");
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("25q");
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
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.math.BigInteger]");

        converter.apply(value);
    }

}