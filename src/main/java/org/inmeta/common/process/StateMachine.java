package org.inmeta.common.process;

/**
 * State Machine public interface.
 * @param <S> The state type
 * @param <E> The event type
 */
public interface StateMachine<S, E> {

    /**
     * Handle event.
     * @param event The event
     * @return The transition result
     */
    TransitionResult handleEvent(Event<E> event);
}
