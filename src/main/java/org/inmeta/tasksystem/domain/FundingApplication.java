package org.inmeta.tasksystem.domain;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Transient;
import org.bson.types.ObjectId;
import org.inmeta.common.process.AbstractStateMachine;
import org.inmeta.common.process.Context;
import org.inmeta.common.process.EventDriven;
import org.inmeta.tasksystem.domain.process.ApplicationProcess;
import org.inmeta.tasksystem.domain.process.ApplicationStates;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class FundingApplication implements EventDriven<FundingApplication> {
    @Id
    private ObjectId id; // auto-generated, if not set (see ObjectId)
    private ApplicationStates state = ApplicationStates.IDLE;

    @Transient
    private AbstractStateMachine process;

    private Applicant applicant;
    private String description;
    private String memberships;

    public FundingApplication() {
        process = new ApplicationProcess(this);
    }

    public AbstractStateMachine getProcess() {
        return process;
    }

    public void setProcess(final AbstractStateMachine process) {
        this.process = process;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(final Applicant applicant) {
        this.applicant = applicant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getMemberships() {
        return memberships;
    }

    public void setMemberships(final String memberships) {
        this.memberships = memberships;
    }

    public ApplicationStates getState() {
        return state;
    }

    public void setState(final ApplicationStates state) {
        this.state = state;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    @Override
    public AbstractStateMachine setExecutor(final Context<? extends FundingApplication> executor) {
        process.setExecutor(executor);
        return process;
    }
}
