package be.haexnet.acsv.converter;

import java.math.BigDecimal;

public class BigDecimalConverter extends NumberConverter<BigDecimal> {

    @Override
    BigDecimal convert(final String value) {
        return new BigDecimal(value);
    }

}
