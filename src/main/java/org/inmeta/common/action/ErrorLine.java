package org.inmeta.common.action;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

/**
 * Error object.
 *
 * @author Alexander Vaagan
 */
public class ErrorLine {
    private String errNo;
    private String message;
    private ObjectError objectError;

    /**
     * Constructor.
     * @param errNo Error number
     * @param message Error message
     */
    public ErrorLine(final String errNo, final String message) {
        this.errNo = errNo;
        this.message = message;
    }

    /**
     * Constructor that takes an ObjectError instead of errNo and message.
     * @param objectError The object error
     */
    public ErrorLine(final ObjectError objectError) {
        this.objectError = objectError;
    }

    public String getErrNo() {
        return errNo;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return errNo + ": " + message;
    }

    /**
     * Convert a list of error lines to a list of strings.
     * @param errors Errors
     * @return Errors
     */
    public static List<String> toStringList(final List<ErrorLine> errors) {
        List<String> strList = new ArrayList<String>(errors.size());
        for(ErrorLine err : errors) {
            strList.add(err.toString());
        }

        return strList;
    }

    public ObjectError getObjectError() {
        return objectError;
    }
}
