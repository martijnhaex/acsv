package be.haexnet.acsv.util;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public final class AnnotationUtil {

    private AnnotationUtil() {
    }

    public static List<Field> getAnnotatedFieldsOf(final Class clazz, final Class<? extends Annotation> annotation) {
        return FluentIterable
                .of(getDeclaredFieldsOf(clazz))
                .filter(isAnnotatedWith(annotation))
                .toList();
    }

    public static Optional<Annotation> getAnnotatedField(final Field field, final Class<? extends Annotation> annotation) {
        final Annotation fieldAnnotation = field.getAnnotation(annotation);

        if (fieldAnnotation != null) {
            return Optional.of(fieldAnnotation);
        }
        return Optional.absent();
    }

    private static Field[] getDeclaredFieldsOf(final Class clazz) {
        return clazz.getDeclaredFields();
    }

    private static Predicate<Field> isAnnotatedWith(final Class<? extends Annotation> annotation) {
        return new Predicate<Field>() {
            @Override
            public boolean apply(final Field field) {
                return field.isAnnotationPresent(annotation);
            }
        };
    }

}
