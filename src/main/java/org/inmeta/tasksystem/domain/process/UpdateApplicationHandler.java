package org.inmeta.tasksystem.domain.process;

import org.inmeta.common.process.EventHandler;
import org.inmeta.common.process.StateMachine;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.inmeta.tasksystem.domain.event.UpdateApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 13:21
 * To change this template use File | Settings | File Templates.
 */
class UpdateApplicationHandler extends EventHandler<UpdateApplicationEvent, FundingApplication> {

    private UpdateApplicationEvent event;

    @Override
    public void setEvent(final UpdateApplicationEvent event) {
        this.event = event;
    }

    @Override
    public void setProcess(final StateMachine process) {
    }

    @Override
    public FundingApplication execute(final FundingApplication target) {
        target.setDescription(event.getDescription());
        target.setMemberships(event.getMemberships());

        return target;
    }
}
