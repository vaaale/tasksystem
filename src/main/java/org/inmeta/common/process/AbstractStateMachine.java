package org.inmeta.common.process;

import org.apache.commons.collections.CollectionUtils;
import org.inmeta.common.action.Action;
import org.inmeta.common.action.ErrorLine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract State Machine.
 *
 * @param <S> State code enum
 * @param <E> Event code enum
 * @param <T> Target type
 * @author Alexander Vaagan
 */
public abstract class AbstractStateMachine<S, E, T> implements StateMachine<S, E> {
    private final Map<S, State<S>> states = new HashMap<S, State<S>>();
    private Context<T> executor;


    /**
     * Add a state.
     *
     * @param state The state
     * @return The state
     */
    public State<S> addState(final State<S> state) {
        states.put(state.getState(), state);
        return state;
    }

    /**
     * Add a state.
     *
     * @param state The state
     * @return The state
     */
    public State<S> addState(final S state) {
        final State<S> newState = new State<S>(state);
        states.put(state, newState);

        return newState;
    }


    /**
     * Handle event.
     * If the current state has a transition mapped by the given event the following will happen:
     * - First all actions on the transition will be executed.
     * - Then all guards on the target state will be checked.
     * - And finally the entry actions on the target state will be executed.
     *
     * @param event The event
     * @return A TransitionResult instance
     */
    @Override
    public TransitionResult handleEvent(final Event<E> event) {
        final TransitionResult result = new TransitionResult();

        final Transition transition = states.get(getState()).getTransition(event);
        if (null != transition) {
            doHandlers(transition, event, result);
            if (canTransition(transition.getTo(), result)) {
                final State<S> newState = transition.getTo();
                setState(newState);
                doEntryActions(newState, result);
            }
        } else {
            result.addError("statemachine.transition.notfound");
            throw new NoSuchTransitionException(getState().toString(), event.toString());
        }


        return result;
    }

    private boolean doEntryActions(final State<S> state, final TransitionResult result) {
        boolean ok = true;

        for (String actionCode : state.getEntryActions()) {
            final StateAction<T> action = executor.lookupAction(actionCode);
            if (null == action) {
                throw new ActionNotFoundException(actionCode);
            }
            action.setProcess(this);
            if (executeAction(executor, action).hasError()) {
                result.addAllErrors(action.getErrors());
                break;
            }
        }

        return ok;
    }

    private boolean doHandlers(final Transition transition, final Event<E> event, final TransitionResult result) {
        boolean ok = true;

        for (String actionName : transition.handlers()) {
            final StateAction<T> action = executor.lookupAction(actionName);
            if (null == action) {
                throw new ActionNotFoundException(actionName);
            }

            EventHandler handler = (EventHandler) action;
            action.setProcess(this);
            action.setTransition(transition);
            handler.setEvent(event);

            if (executeAction(executor, action).hasError()) {
                result.addAllErrors(action.getErrors());
                break;
            }
        }

        return ok;
    }

    // Check guards.
    private boolean canTransition(final State state, final TransitionResult result) {
        boolean ok = true;
        final List<Guard> guards = state.guards();
        for (Guard g : guards) {
            if (!checkGuard(executor, g)) {
                if (CollectionUtils.isNotEmpty(g.getErrors())) {
                    result.addAllErrors(g.getErrors());
                } else {
                    result.addError(new ErrorLine("GUARD", "State unreachable!"));
                }
                ok = false;
            }
        }

        return ok;
    }

    /**
     * Get the current state.
     *
     * @return The state
     */
    public abstract S getState();

    /**
     * Set state.
     *
     * @param state The state
     */
    public abstract void setState(final State<S> state);

    /**
     * Check a guard.
     *
     * @param executor The command executor
     * @param guard    The guard to check
     * @return true or false
     */
    public abstract boolean checkGuard(final Context<T> executor, final Guard<T> guard);

    /**
     * Execute an action.
     *
     * @param executor The command executor
     * @param action   The action to execute
     * @return The executed action
     */
    public abstract Action<T> executeAction(final Context<T> executor, final Action<T> action);


    /**
     * Add Transition.
     *
     * @param from    From state
     * @param to      To state
     * @param trigger Event
     * @return The transition
     */
    public Transition addTransition(final State from, final State to, final E trigger) {
        return from.addTransition(new Transition(from, to, trigger));
    }

    /**
     * Get all transitions from current state.
     *
     * @return A list of transitions
     */
    public List<Transition> getTransitions() {
        final List<Transition> transitions = new ArrayList<Transition>();
        transitions.addAll(states.get(getState()).getTransitions());

        return transitions;
    }


    public void setExecutor(final Context executor) {
        this.executor = executor;
    }

    /**
     * Determine if the a transition to the given state can be done.
     *
     * @param state The state.
     * @return result
     */
    public TransitionResult canMakeTransition(final S state) {
        final TransitionResult result = new TransitionResult();

        final List<Transition> transitions = getTransitions();

        for (Transition t : transitions) {
            final State targetState = t.getTo();
            if (targetState.getState() == state) {
                canTransition(targetState, result);
            }
        }

        return result;
    }
}
