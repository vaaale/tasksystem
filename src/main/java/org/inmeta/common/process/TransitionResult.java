package org.inmeta.common.process;

import org.inmeta.common.action.ErrorLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Transition result object.
 *
 * @author Alexander Vaagan
 */
public class TransitionResult {
    private List<ErrorLine> errors = new ArrayList<ErrorLine>();

    /**
     * Add error.
     * @param error The error
     */
    public void addError(final String error) {
        this.errors.add(new ErrorLine("TRANSISTION", error));
    }

    /**
     * Add error.
     * @param errorLine Errro line
     */
    public void addError(final ErrorLine errorLine) {
        this.errors.add(errorLine);
    }

    /**
     * Check if there exists errors.
     * @return true or false
     */
    public boolean hasError() {
        return errors.size() > 0;
    }

    /**
     * Print the contets.
     * used for debugging.
     */
    public void print() {
        for(ErrorLine error : errors) {
            System.out.println(error);
        }
    }

    public List<ErrorLine> getErrors() {
        return errors;
    }

    /**
     * Add all errors.
     * @param errors The errors
     */
    public void addAllErrors(final List<ErrorLine> errors) {
        this.errors.addAll(errors);
    }
}
