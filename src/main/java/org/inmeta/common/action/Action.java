package org.inmeta.common.action;

import java.util.Collection;
import java.util.List;

/**
 * Interface defining an action to be executed on a given instance T.
 *
 * @param <T> The type of instance
 */
public abstract class Action<T> {

    private ResultMapper<T, ?> result;


    /**
     * Default constructor.
     */
    public Action() {
        this.result = new ResultMapper<T, Object>() {
            @Override
            public ResultMapper<T, Object> build(final T result) {
                return this;
            }

            @Override
            public ResultMapper<T, Object> build(final Collection<T> list) {
                return this;
            }

            @Override
            public List<Object> getResultList() {
                return null;
            }

            @Override
            public Object getSingleResult() {
                return null;
            }
        };
    }

    /**
     * Constructor.
     *
     * @param result Resultbuilder
     */
    public Action(final ResultMapper<T, ?> result) {
        this.result = result;
    }

    /**
     * Get the list of errors.
     *
     * @return A list of errors
     */
    public final List<ErrorLine> getErrors() {
        return result.getErrors();
    }

    /**
     * Add error.
     *
     * @param error The error
     * @return this
     */
    public final Action<T> addError(final String error) {
        result.addError(error);

        return this;
    }


    /**
     * Add all error.
     *
     * @param errors The errors
     * @return this
     */
    public final Action<T> addAllErrors(final List<ErrorLine> errors) {
        result.addAllErrors(errors);
        return this;
    }


    /**
     * Determine if the action contains errors.
     *
     * @return true / false
     */
    public final boolean hasError() {
        return result.hasError();
    }

    /**
     * Add a warning.
     *
     * @param warning The warning
     * @return this
     */
    public Action<T> addWarning(final String warning) {
        result.addWarning(warning);
        return this;
    }

    /**
     * Add all warning.
     *
     * @param warning The warning
     * @return this
     */
    public Action<T> addAllWarning(final List<ErrorLine> warning) {
        result.addAllWarnings(warning);
        return this;
    }


    /**
     * Execute the action.
     *
     * @param target Target
     * @return target
     */
    public abstract T execute(final T target);

    /**
     * Get the result from the action.
     *
     * @return The result
     */
    public ResultMapper<?, ?> getResult() {
        return result;
    }

    /**
     * Build the result.
     * Subclasses should overload this if you need to build a custom result.
     * The method i called after save is called on the target return from execute.
     *
     * @param saved The saved instance
     * @return this
     */
    public Action<T> buildResult(final T saved) {
        result.build(saved);
        return this;
    }


}
