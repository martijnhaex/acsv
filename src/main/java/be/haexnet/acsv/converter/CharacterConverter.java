package be.haexnet.acsv.converter;

import be.haexnet.acsv.exception.ACSVFormatException;
import org.apache.commons.lang3.StringUtils;

public class CharacterConverter implements TypeConverter<Character> {

    @Override
    public Character apply(final String value) {
        if (StringUtils.isNotBlank(value)) {
            return value.charAt(0);
        }
        throw new ACSVFormatException(value, Character.class);
    }

    @Override
    public Class appliesFor() {
        return Character.class;
    }

}
