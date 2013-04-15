package org.inmeta.common.process;

/**
 * Abstract event handler.
 * Action to handle an event. The handler is invoked on a transition.
 *
 * @param <E> The event type
 * @param <T> The target object type
 *
 * @author Alexander Vaagan
 */
public abstract class EventHandler<E, T> extends StateAction<T> {

    /**
     * Set the event.
     * @param event The event
     */
    public abstract void setEvent(final E event);

}
