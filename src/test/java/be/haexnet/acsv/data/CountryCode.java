package be.haexnet.acsv.data;

public class CountryCode {

    private String iso2Code;

    private CountryCode(final String iso2Code) {
        this.iso2Code = iso2Code;
    }

    public static CountryCode from(final String iso2Code) {
        return new CountryCode(iso2Code);
    }

    public String getIso2Code() {
        return iso2Code;
    }
}
