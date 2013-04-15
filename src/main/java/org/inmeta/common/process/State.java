package org.inmeta.common.process;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * State.
 *
 * @param <C> The state codes
 * @author Alexander Vaagan
 */
public class State<C> {
    private C state;
    private Map<Object, Transition> transitions = new HashMap<Object, Transition>();
    private List<String> entryActions = new ArrayList<String>();
    private List<Guard> guards = new ArrayList<Guard>();

    /**
     * Constrctor.
     *
     * @param state The state
     */
    public State(final C state) {
        this.state = state;
    }

    public C getState() {
        return state;
    }

    /**
     * Add a transition.
     *
     * @param transition The transition
     * @return the transition
     */
    public Transition addTransition(final Transition transition) {
        transitions.put(transition.getTrigger(), transition);
        return transition;
    }

    /**
     * Get transition for given event.
     *
     * @param event The event
     * @return The transition or null if not found
     */
    public Transition getTransition(final Event event) {
        return transitions.get(event.getEventCode());
    }

    /**
     * Add a guard.
     *
     * @param guard The guard
     * @return The state
     */
    public State<C> addGuard(final Guard guard) {
        guards.add(guard);
        return this;
    }

    /**
     * Get the guards.
     *
     * @return The guards
     */
    public List<Guard> guards() {
        return guards;
    }

    /**
     * Add an action.
     *
     * @param action The action
     * @return The state
     */
    public State<C> addAction(final String action) {
        entryActions.add(action);
        return this;
    }

    /**
     * Add an action.
     *
     * @param action The action
     * @return The state
     */
    public State<C> addAction(final Enum action) {
        entryActions.add(action.toString());
        return this;
    }

    /**
     * Get all entry actions.
     *
     * @return the actions
     */
    public List<String> getEntryActions() {
        return entryActions;
    }

    public Collection<Transition> getTransitions() {
        return transitions.values();
    }
}
