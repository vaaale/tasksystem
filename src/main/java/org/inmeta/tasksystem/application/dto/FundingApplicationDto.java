package org.inmeta.tasksystem.application.dto;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class FundingApplicationDto extends AbstractResponse {
    private String name;
    private String email;
    private String accountNumber;
    private String description;
    private String memberships;
    private String state;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
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

    public void setState(final String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
