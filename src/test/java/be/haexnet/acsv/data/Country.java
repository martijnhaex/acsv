package be.haexnet.acsv.data;

import be.haexnet.acsv.annotation.ACSVColumn;
import be.haexnet.acsv.data.converter.CountryCodeConverter;

public class Country {

    @ACSVColumn(converter = CountryCodeConverter.class)
    private CountryCode countryCode;
    @ACSVColumn
    private String nameWithSpecialCharacters;
    @ACSVColumn
    private String nameWithoutSpecialCharacters;

    public CountryCode getCountryCode() {
        return countryCode;
    }

    public String getNameWithSpecialCharacters() {
        return nameWithSpecialCharacters;
    }

    public String getNameWithoutSpecialCharacters() {
        return nameWithoutSpecialCharacters;
    }

}
