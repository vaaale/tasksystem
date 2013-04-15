package org.inmeta.common.process;

/**
 * No such transition.
 * Thrown when there is not transition for the received event.
 *
 * @author Alexander Vaagan
 */
public class NoSuchTransitionException extends RuntimeException {

    /**
     * Constructor.
     * @param state The state name
     * @param event The event code
     */
    public NoSuchTransitionException(final String state, final String event) {
        super(String.format("No transition found from state %s by event %s\n", state, event));
    }
}
