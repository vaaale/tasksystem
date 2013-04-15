package org.inmeta.common.process;


import org.inmeta.common.action.ErrorLine;

import java.util.ArrayList;
import java.util.List;

/**
 * Guard superclass.
 *
 * @param <T> The target type
 * @author Alexander Vaagan
 */
public abstract class Guard<T> {
    private List<ErrorLine> errors = new ArrayList<ErrorLine>();

    /**
     * Add error.
     *
     * @param error The error
     * @return The guard
     */
    public Guard<T> addError(final ErrorLine error) {
        errors.add(error);
        return this;
    }

    /**
     * Evaludate this guard.
     *
     * @param target The target
     * @return true or false
     */
    public abstract boolean check(T target);

    public List<ErrorLine> getErrors() {
        return errors;
    }
}
