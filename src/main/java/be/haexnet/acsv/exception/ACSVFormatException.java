package be.haexnet.acsv.exception;

public class ACSVFormatException extends RuntimeException {

    public ACSVFormatException(final String value, final String type) {
        super("Format exception occurred when converting value [" + value + "] to type [" + type + "]");
    }

}
