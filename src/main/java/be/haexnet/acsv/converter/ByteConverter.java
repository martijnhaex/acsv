package be.haexnet.acsv.converter;

public class ByteConverter extends NumberConverter<Byte> {

    @Override
    Byte convert(final String value) {
        return Byte.valueOf(value);
    }

}
