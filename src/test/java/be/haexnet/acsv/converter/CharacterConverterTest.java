package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.fest.assertions.api.Assertions.assertThat;

public class CharacterConverterTest {

    CharacterConverter converter = new CharacterConverter();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void returnsCharacterWhenInputHasOnlyOneCharacter() {
        assertThat(converter.apply("I")).isEqualTo('I');
    }

    @Test
    public void returnsFirstCharacterWhenInputHasMultipleCharacters() {
        assertThat(converter.apply("jetbrains")).isEqualTo('j');
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
        expectedException.expectMessage("Format exception occurred when converting value [" + value + "] to type [java.lang.Character]");

        converter.apply(value);
    }

}