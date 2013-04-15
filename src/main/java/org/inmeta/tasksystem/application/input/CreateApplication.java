package org.inmeta.tasksystem.application.input;

import org.inmeta.common.action.InputBuilder;
import org.inmeta.tasksystem.application.dto.ApplicantDto;
import org.inmeta.tasksystem.domain.Applicant;
import org.inmeta.tasksystem.domain.event.CreateApplicationEvent;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:25
 * To change this template use File | Settings | File Templates.
 */
public class CreateApplication extends InputBuilder<CreateApplicationEvent> {

    private ApplicantDto dto;

    public CreateApplication(final ApplicantDto dto) {
        this.dto = dto;
    }

    @Override
    public CreateApplicationEvent get() {
        final Applicant applicant = new Applicant();
        applicant.setAccountNumber(dto.getAccountNumber());
        applicant.setEmail(dto.getEmail());
        applicant.setName(dto.getName());
        final CreateApplicationEvent event = new CreateApplicationEvent(applicant);

        return event;
    }
}
