package org.inmeta.common.process;

import java.util.ArrayList;
import java.util.List;

/**
 * Transition.
 */
public class Transition {

    private final State from;
    private final State to;
    private final Object trigger;

    private List<String> actions = new ArrayList<String>();

    /**
     * Constructor.
     * @param from From state
     * @param to To state
     * @param trigger Event
     */
    Transition(final State from, final State to, final Object trigger) {
        this.from = from;
        this.to = to;
        this.trigger = trigger;
    }

    /**
     * Add an action to the transition.
     * @param action The action
     * @return The transition
     */
    public Transition addHandler(final String action) {
        actions.add(action);
        return this;
    }

    /**
     * Add an action to the transition.
     * @param action The action
     * @return The transition
     */
    public Transition addHandler(final Enum action) {
        actions.add(action.toString());
        return this;
    }

    /**
     * Get all actions.
     * @return List of actions
     */
    public List<String> handlers() {
        return actions;
    }

    public State getFrom() {
        return from;
    }

    public State getTo() {
        return to;
    }

    public Object getTrigger() {
        return trigger;
    }
}
