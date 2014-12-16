package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class LongConverterTest {

    LongConverter converter = new LongConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsNumberWhenInputIsValidNumber() {
        assertThat(converter.apply("5821")).isEqualTo(5821);
    }

    @Test
    public void throwsACSVFormatExceptionWhenInputIsInvalidNumber() {
        expectACSVFormatException("1983l");
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
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Long]");

        converter.apply(value);
    }

}