package org.inmeta.tasksystem.application.input;

import org.inmeta.common.action.InputBuilder;
import org.inmeta.common.action.Query;
import org.inmeta.tasksystem.domain.query.PersonQuery;
import org.inmeta.tasksystem.integrations.Person;
import org.inmeta.tasksystem.integrations.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 16:00
 * To change this template use File | Settings | File Templates.
 */
public class PersonQueryBuilder extends InputBuilder<Query<Provider, Person>> {

    private String query;

    public PersonQueryBuilder(final String query) {
        this.query = query;
    }

    @Override
    public Query<Provider, Person> get() {
        return new PersonQuery(query);
    }
}
