package be.haexnet.acsv.converter;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class StringConverterTest {

    StringConverter converter = new StringConverter();

    @Test
    public void returnsInput() {
        final String value = "This will be returned!";
        assertThat(converter.apply(value)).isSameAs(value);
    }

    @Test
    public void returnsInputWhenEmpty() {
        final String value = "";
        assertThat(converter.apply(value)).isSameAs(value);
    }

    @Test
    public void returnsInputWhenNull() throws Exception {
        assertThat(converter.apply(null)).isNull();
    }

    @Test
    public void appliesForString() {
        assertThat(converter.appliesFor()).isEqualTo(String.class);
    }

}