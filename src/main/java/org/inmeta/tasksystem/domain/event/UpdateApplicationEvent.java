package org.inmeta.tasksystem.domain.event;

import org.inmeta.common.process.Event;
import org.inmeta.tasksystem.domain.process.ApplicationEvents;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:06
 * To change this template use File | Settings | File Templates.
 */
public class UpdateApplicationEvent extends Event<ApplicationEvents> {
    private String description;
    private String memberships;

    /**
     * Constructor.
     *
     */
    public UpdateApplicationEvent() {
        super(ApplicationEvents.UPDATE_APPLICATION);
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setMemberships(final String memberships) {
        this.memberships = memberships;
    }

    public String getDescription() {
        return description;
    }

    public String getMemberships() {
        return memberships;
    }
}
