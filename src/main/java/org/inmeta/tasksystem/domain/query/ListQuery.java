package org.inmeta.tasksystem.domain.query;

import com.google.code.morphia.Datastore;
import org.bson.types.ObjectId;
import org.inmeta.common.action.Query;
import org.inmeta.tasksystem.domain.FundingApplication;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 01:31
 * To change this template use File | Settings | File Templates.
 */
public class ListQuery implements Query<Datastore, FundingApplication> {
    private String id;

    public ListQuery(final String id) {
        this.id = id;
    }

    @Override
    public List<FundingApplication> find(final Datastore db) {

        final com.google.code.morphia.query.Query<FundingApplication> query = db.find(FundingApplication.class);

        if(null != id) {
            query.field("id").equal(new ObjectId(id));
        }

        final List<FundingApplication> list = query.asList();


        return list;
    }
}
