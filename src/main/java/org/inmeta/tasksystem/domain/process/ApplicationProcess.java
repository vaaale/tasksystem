package org.inmeta.tasksystem.domain.process;

import org.inmeta.common.action.Action;
import org.inmeta.common.process.AbstractStateMachine;
import org.inmeta.common.process.Context;
import org.inmeta.common.process.Guard;
import org.inmeta.common.process.State;
import org.inmeta.tasksystem.domain.FundingApplication;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationProcess extends AbstractStateMachine<ApplicationStates, ApplicationEvents, FundingApplication> {
    private FundingApplication task;

    public ApplicationProcess(final FundingApplication task) {
        this.task = task;

        createStateMachine();
    }

    private void createStateMachine() {
        final State<ApplicationStates> idleState = addState(ApplicationStates.IDLE);
        final State<ApplicationStates> newState = addState(ApplicationStates.NEW);
        final State<ApplicationStates> openState = addState(ApplicationStates.OPEN);
        final State<ApplicationStates> approvedState = addState(ApplicationStates.APPROVED);
        final State<ApplicationStates> closedState = addState(ApplicationStates.CLOSED);
        final State<ApplicationStates> rejectedState = addState(ApplicationStates.REJECTED);

        addTransition(idleState, newState, ApplicationEvents.CREATE)
                .addHandler(Handlers.CREATE);

        addTransition(newState, openState, ApplicationEvents.UPDATE_APPLICATION)
                .addHandler(Handlers.UPDATE_APPLICATION);

        addTransition(openState, openState, ApplicationEvents.UPDATE_APPLICATION)
                .addHandler(Handlers.UPDATE_APPLICATION);

        addTransition(openState, rejectedState, ApplicationEvents.REJECT);

        addTransition(openState, approvedState, ApplicationEvents.APPROVE);

        addTransition(approvedState, closedState, ApplicationEvents.CLOSE);


    }

    @Override
    public ApplicationStates getState() {
        return task.getState();
    }

    @Override
    public void setState(final State<ApplicationStates> state) {
        task.setState(state.getState());
    }

    @Override
    public boolean checkGuard(final Context<FundingApplication> executor, final Guard<FundingApplication> guard) {
        return guard.check(task);
    }

    @Override
    public Action<FundingApplication> executeAction(final Context<FundingApplication> executor, final Action<FundingApplication> action) {
        task = action.execute(task);

        return action;
    }
}
