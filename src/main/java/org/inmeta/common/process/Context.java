package org.inmeta.common.process;


/**
 * Executor.
 * Implementations of this interface should handle execution an evaluation of guards and actions.
 * It must also handle transactions.
 *
 * @param <T> The target object type
 * @author Alexander Vaagan
 */
public interface Context<T> {

    /**
     * Lookup handler.
     * @param code Tha handler code
     * @return The handler
     */
    StateAction<T> lookupAction(final String code);
}
