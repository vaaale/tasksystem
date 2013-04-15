package org.inmeta.common.process;


import org.inmeta.common.action.Action;

/**
 * Abstract state action.
 * @param <T> The process type
 */
public abstract class StateAction<T> extends Action<T> {

    private Transition transition;

    /**
     * Set the process.
     * This method is called prior to execution.
     * @param process The process
     */
    public abstract void setProcess(final StateMachine process);

    public void setTransition(final Transition transition) {
        this.transition = transition;
    }

    public final Transition getTransition() {
        return transition;
    }
}
