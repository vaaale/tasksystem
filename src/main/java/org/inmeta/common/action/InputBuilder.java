package org.inmeta.common.action;

/**
 * Action source.
 *
 * @param <R> The destination type
 */
public abstract class InputBuilder<R> {

    /**
     * Get.
     * @return the object
     */
    public abstract R get();
}
