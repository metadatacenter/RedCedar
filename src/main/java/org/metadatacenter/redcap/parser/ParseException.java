package org.metadatacenter.redcap.parser;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2023-04-12
 */
public class ParseException extends RuntimeException {

    public ParseException() {
        super();
    }

    public ParseException(String message) {
        super(message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseException(Throwable cause) {
        super(cause);
    }

    protected ParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
