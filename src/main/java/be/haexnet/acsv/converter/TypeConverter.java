package be.haexnet.acsv.converter;

public interface TypeConverter<Type> {

     public Type apply(String value);

}
