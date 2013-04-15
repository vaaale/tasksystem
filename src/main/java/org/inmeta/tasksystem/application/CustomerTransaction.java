package org.inmeta.tasksystem.application;

import org.inmeta.common.action.InputBuilder;
import org.inmeta.common.action.Query;
import org.inmeta.common.action.ResultMapper;
import org.inmeta.tasksystem.application.dto.CustomerDto;
import org.inmeta.tasksystem.integrations.GuleSiderProvider;
import org.inmeta.tasksystem.integrations.Person;
import org.inmeta.tasksystem.integrations.Provider;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CustomerTransaction {


    public ResultMapper<Person, ?> find(final InputBuilder<Query<Provider, Person>> queryBuilder,
                                        final ResultMapper<Person, CustomerDto> mapper) {
        return mapper.build(queryBuilder.get().find(new GuleSiderProvider()));
    }
}

