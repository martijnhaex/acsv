package be.haexnet.acsv.util;

import be.haexnet.acsv.annotation.ACSVColumn;
import com.google.common.base.Optional;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Assertions.extractProperty;

public class AnnotationUtilTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void getAnnotatedFieldsWillReturnAllAnnotatedFields() throws Exception {
        final List<Field> annotatedFields = AnnotationUtil.getAnnotatedFieldsOf(new WithAnnotation(), ACSVColumn.class);
        assertThat(annotatedFields).hasSize(2);
        assertThat(extractProperty("name").from(annotatedFields)).containsOnly("name", "function");
    }

    @Test
    public void getAnnotatedFieldsWillReturnEmptyListWhenNoAnnotatedFields() throws Exception {
        assertThat(AnnotationUtil.getAnnotatedFieldsOf(new WithoutAnnotations(), ACSVColumn.class)).isEmpty();
    }

    @Test
    public void getAnnotatedFieldsWillReturnEmptyListWhenNoDeclaredFields() throws Exception {
        assertThat(AnnotationUtil.getAnnotatedFieldsOf(new WithoutFields(), ACSVColumn.class)).isEmpty();
    }

    @Test
    public void getAnnotatedField() throws Exception {
        final Field field = WithAnnotation.class.getDeclaredField("name");

        final Optional<Annotation> annotatedField = AnnotationUtil.getAnnotatedField(field, ACSVColumn.class);
        assertThat(annotatedField.isPresent()).isTrue();
        assertThat((ACSVColumn) annotatedField.get()).isNotNull();
    }

    @Test
    public void getAnnotatedFieldWillReturnOptionalAbsentWhenNotAnnotated() throws Exception {
        final Field field = WithAnnotation.class.getDeclaredField("degree");

        final Optional<Annotation> annotatedField = AnnotationUtil.getAnnotatedField(field, ACSVColumn.class);
        assertThat(annotatedField.isPresent()).isFalse();
    }

    @Test
    public void getAnnotatedFieldReturnsOptionalAbsentWhenFieldNotExists() throws Exception {
        final Field field = WithoutAnnotations.class.getDeclaredField("id");

        final Optional<Annotation> annotatedField = AnnotationUtil.getAnnotatedField(field, ACSVColumn.class);
        assertThat(annotatedField.isPresent()).isFalse();
    }

    private static class WithAnnotation {
        @ACSVColumn
        private String name;
        @ACSVColumn
        private String function;
        private String degree;
    }

    private static class WithoutAnnotations {
        private String id;
        private String name;
        private String function;
    }

    private static class WithoutFields {

    }

}