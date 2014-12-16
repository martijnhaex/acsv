package be.haexnet.acsv.converter;

import java.math.BigInteger;

public class BigIntegerConverter extends NumberConverter<BigInteger> {

    @Override
    BigInteger convert(final String value) {
        return new BigInteger(value);
    }

}
