package org.inmeta.common.process;

/**
 * Interface defining an EventDriven task.
 * @param <T> The type of task
 */
public interface EventDriven<T> {
    /**
     * Set executor.
     * This method is part of the state machine.
     * It will set the executor and return a reference to the statemachine for further processing.
     * @param executor The executor
     * @return The state machine
     */
     AbstractStateMachine setExecutor(Context<? extends T> executor);
}
