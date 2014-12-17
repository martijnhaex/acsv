package be.haexnet.acsv.data.converter;

import be.haexnet.acsv.converter.TypeConverter;
import be.haexnet.acsv.data.CountryCode;

public class CountryCodeConverter implements TypeConverter<CountryCode> {

    @Override
    public CountryCode apply(final String value) {
        return CountryCode.from(value);
    }

    @Override
    public Class appliesFor() {
        return CountryCode.class;
    }

}
