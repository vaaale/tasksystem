package org.inmeta.tasksystem.application.dto;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractResponse {
    private String id;

    public void setId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
