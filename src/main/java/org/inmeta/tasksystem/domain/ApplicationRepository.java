package org.inmeta.tasksystem.domain;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.inmeta.common.action.Query;
import org.springframework.stereotype.Repository;

import java.net.UnknownHostException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 01:25
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ApplicationRepository {
    private MongoClient mongoClient;
    private Datastore ds;

    public ApplicationRepository() {
        try {
            mongoClient = new MongoClient("localhost");
            ds = new Morphia().map(FundingApplication.class).createDatastore(mongoClient, "application");

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public Collection<FundingApplication> find(final Query<Datastore, FundingApplication> query) {
        return query.find(ds);
    }

    public FundingApplication save(final FundingApplication application) {
        final Key<FundingApplication> save = ds.save(application);

        return application;
    }

    public FundingApplication findById(final String id) {
        return ds.get(FundingApplication.class, new ObjectId(id));
    }
}
