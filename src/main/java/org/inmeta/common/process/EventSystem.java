package org.inmeta.common.process;


import org.inmeta.common.action.Factory;

/**
 * Interface defining an event driven system.
 *
 * @param <T> Process type
 *
 * @author Alexander Vaagan
 */
public interface EventSystem<T extends EventDriven> {
    /**
     * Submit event.
     * @param process The process to submit the event to
     * @param event The event
     * @return The result
     */
    TransitionResult submitEvent(EventDriven<T> process, Event event);

    /**
     * Create.
     * @param factory Factory to create the new process
     * @param event Event
     * @return The created process
     */
    T create(Factory<T> factory, Event event);
}
