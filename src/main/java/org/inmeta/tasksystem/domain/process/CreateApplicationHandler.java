package org.inmeta.tasksystem.domain.process;

import org.inmeta.common.process.EventHandler;
import org.inmeta.common.process.StateMachine;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.inmeta.tasksystem.domain.event.CreateApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
class CreateApplicationHandler extends EventHandler<CreateApplicationEvent, FundingApplication> {

    private CreateApplicationEvent event;

    @Override
    public void setEvent(final CreateApplicationEvent event) {
        this.event = event;
    }

    @Override
    public void setProcess(final StateMachine process) {
    }

    @Override
    public FundingApplication execute(final FundingApplication target) {
        target.setApplicant(event.getApplicant());

        return target;
    }
}
