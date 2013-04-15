package org.inmeta.common.action;

/**
 * Abstract factory.
 * @param <R> The type to create
 */
public interface Factory<R> {

    /**
     * Create.
     * @return object
     */
    public R create();

}
