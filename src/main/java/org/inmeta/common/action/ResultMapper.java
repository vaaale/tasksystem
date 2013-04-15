package org.inmeta.common.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Result object.
 *
 * @param <S> The type of object that this result instance should handle.
 * @param <T> The result entity type.
 * @author Alexander Vaagan
 */
public abstract class ResultMapper<S, T> {
    private List<ErrorLine> errors;
    private List<ErrorLine> warnings;

    /**
     * Constructor.
     */
    public ResultMapper() {
        errors = new ArrayList<ErrorLine>();
        warnings = new ArrayList<ErrorLine>();
    }

    /**
     * Add a single error to the result.
     *
     * @param error The error
     * @return this
     */
    public ResultMapper<S, T> addError(final String error) {
        errors.add(new ErrorLine("GENERAL", error));
        return this;
    }

    /**
     * Add a list of errors.
     *
     * @param errors The errors
     * @return this
     */
    public ResultMapper<S, T> addAllErrors(final List<ErrorLine> errors) {
        this.errors.addAll(errors);
        return this;
    }

    /**
     * Get all errors.
     *
     * @return The errors
     */
    public List<ErrorLine> getErrors() {
        return errors;
    }

    /**
     * Add a warning.
     *
     * @param warning The warning
     * @return this
     */
    public ResultMapper<S, T> addWarning(final String warning) {
        warnings.add(new ErrorLine("GENERAL", warning));
        return this;
    }

    /**
     * Add a list of warnings.
     *
     * @param warnings The warnings
     * @return this
     */
    public ResultMapper<S, T> addAllWarnings(final List<ErrorLine> warnings) {
        this.warnings.addAll(warnings);
        return this;
    }

    /**
     * Get the list of warnings.
     *
     * @return The warnings
     */
    public List<ErrorLine> getWarnings() {
        return warnings;
    }

    /**
     * Builds a single result object.
     *
     * @param result The result object
     * @return this
     */
    public abstract ResultMapper<S, T> build(S result);

    /**
     * Build a list of result objects.
     *
     * @param list The list of result objects
     * @return this
     */
    public abstract ResultMapper<S, T> build(Collection<S> list);

    /**
     * Get result as list.
     * No manipulation of the <S> objects should be done here since its outside the transaction boundary.
     *
     * @return The result as list
     */
    public abstract List<T> getResultList();


    /**
     * Get the single result.
     * No manipulation of the <S> objects should be done here since its outside the transaction boundary.
     *
     * @return The result
     */
    public abstract T getSingleResult();

    /**
     * Check if the result contains errors.
     *
     * @return true / false
     */
    public boolean hasError() {
        return errors.size() > 0;
    }

    /**
     * Check if the result contains warnings.
     *
     * @return true / false
     */
    public boolean hasWarning() {
        return warnings.size() > 0;
    }
}
