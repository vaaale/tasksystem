package org.inmeta.tasksystem.application.input;

import org.inmeta.common.action.InputBuilder;
import org.inmeta.tasksystem.application.dto.FundingApplicationDto;
import org.inmeta.tasksystem.domain.event.UpdateApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:25
 * To change this template use File | Settings | File Templates.
 */
public class UpdateApplication extends InputBuilder<UpdateApplicationEvent> {

    private FundingApplicationDto dto;

    public UpdateApplication(final FundingApplicationDto dto) {
        this.dto = dto;
    }

    @Override
    public UpdateApplicationEvent get() {
        final UpdateApplicationEvent event = new UpdateApplicationEvent();
        event.setDescription(dto.getDescription());
        event.setMemberships(dto.getMemberships());

        return event;
    }
}
