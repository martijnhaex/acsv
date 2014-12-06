package be.haexnet.acsv.util;

import be.haexnet.acsv.exception.ACSVAccessException;
import be.haexnet.acsv.exception.ACSVConfigurationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class ReflectionUtil {

    private ReflectionUtil() { }

    public static Object getFieldValue(final Object entity, final Field field) {
        final boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            return field.get(entity);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new ACSVAccessException("Cannot get value from field: " + field.getName() + " on instance of: " + entity.getClass() + ".");
        } finally {
            field.setAccessible(accessible);
        }
    }

    public static Field getFieldByFieldName(final Object entity, final String fieldName) {
        try {
            return entity.getClass().getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new ACSVConfigurationException("Could not find field: " + fieldName + " on instance of: " + entity.getClass() + ".");
        }
    }

    public static void setFieldValue(final Object entity, final Field field, final Object value) {
        final boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
            field.set(entity, value);
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new ACSVAccessException("Cannot set value: " + value + " to field: " + field.getName() + " on instance of: " + entity.getClass() + ".");
        } finally {
            field.setAccessible(accessible);
        }
    }

    public static Constructor<?> getDefaultConstructor(final Field field) {
        try {
            return field.getType().getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new ACSVConfigurationException("Cannot get default constructor for: " + field.getType() + ".");
        }
    }

    public static Constructor<?> getDefaultConstructor(final Class clazz) {
        try {
            return clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new ACSVConfigurationException("Cannot get default constructor for: " + clazz + ".");
        }
    }

    public static Object createNewInstanceFor(final Class clazz) {
        final Constructor<?> defaultConstructor = getDefaultConstructor(clazz);
        final boolean accessible = defaultConstructor.isAccessible();
        defaultConstructor.setAccessible(true);
        try {
            return defaultConstructor.newInstance();
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new ACSVAccessException("Cannot create new instance for: " + clazz + ".");
        } finally {
            defaultConstructor.setAccessible(accessible);
        }
    }

}
