package org.inmeta.tasksystem.domain.query;

import org.inmeta.common.action.Query;
import org.inmeta.tasksystem.integrations.Person;
import org.inmeta.tasksystem.integrations.Provider;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 15:59
 * To change this template use File | Settings | File Templates.
 */
public class PersonQuery implements Query<Provider, Person> {

    private String query;

    public PersonQuery(final String query) {
        this.query = query;
    }

    @Override
    public List<Person> find(final Provider manager) {
        final List<Person> result = manager.lookup(query);

        return result;
    }
}
