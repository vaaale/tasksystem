package org.inmeta.tasksystem.application.input;

import com.google.code.morphia.Datastore;
import org.inmeta.common.action.InputBuilder;
import org.inmeta.common.action.Query;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.inmeta.tasksystem.domain.query.ListQuery;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 01:32
 * To change this template use File | Settings | File Templates.
 */
public class ListQueryBuilder extends InputBuilder<Query<Datastore, FundingApplication>> {
    private String id;

    public ListQueryBuilder() {

    }

    public ListQueryBuilder(final String id) {
        this.id = id;
    }


    @Override
    public Query<Datastore, FundingApplication> get() {
        return new ListQuery(id);
    }
}
