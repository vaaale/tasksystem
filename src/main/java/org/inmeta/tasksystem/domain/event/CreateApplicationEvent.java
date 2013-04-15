package org.inmeta.tasksystem.domain.event;

import org.inmeta.common.process.Event;
import org.inmeta.tasksystem.domain.Applicant;
import org.inmeta.tasksystem.domain.process.ApplicationEvents;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:06
 * To change this template use File | Settings | File Templates.
 */
public class CreateApplicationEvent extends Event<ApplicationEvents> {
    private Applicant applicant;

    /**
     * Constructor.
     *
     */
    public CreateApplicationEvent(final Applicant applicant) {
        super(ApplicationEvents.CREATE);
        this.applicant = applicant;
    }

    public Applicant getApplicant() {
        return applicant;
    }
}
