package be.haexnet.acsv.converter;

import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class BooleanConverterTest {

    BooleanConverter converter = new BooleanConverter();

    @Test
    public void returnsTrueWhenInputIsTrue() {
        assertThat(converter.apply("true")).isTrue();
    }

    @Test
    public void returnsTrueWhenInputIsYes() {
        assertThat(converter.apply("yes")).isTrue();
    }

    @Test
    public void returnsTrueWhenInputIsY() {
        assertThat(converter.apply("y")).isTrue();
    }

    @Test
    public void returnsTrueWhenInputIs1() {
        assertThat(converter.apply("1")).isTrue();
    }

    @Test
    public void returnsFalseWhenInputIsFalse() {
        assertThat(converter.apply("false")).isFalse();
    }

    @Test
    public void returnsFalseWhenInputIsNo() {
        assertThat(converter.apply("no")).isFalse();
    }

    @Test
    public void returnsFalseWhenInputIsN() {
        assertThat(converter.apply("n")).isFalse();
    }

    @Test
    public void returnsFalseWhenInputIs0() {
        assertThat(converter.apply("0")).isFalse();
    }

    @Test
    public void returnsFalseWhenInputIsEmpty() {
        assertThat(converter.apply("")).isFalse();
    }

    @Test
    public void returnsFalseWhenInputIsNull() {
        assertThat(converter.apply(null)).isFalse();
    }

    @Test
    public void appliesForBoolean() {
        assertThat(converter.appliesFor()).isEqualTo(Boolean.class);
    }

}