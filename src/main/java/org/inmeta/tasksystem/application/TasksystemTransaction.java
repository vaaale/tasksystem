package org.inmeta.tasksystem.application;

import com.google.code.morphia.Datastore;
import org.inmeta.common.action.InputBuilder;
import org.inmeta.common.action.Query;
import org.inmeta.common.action.ResultMapper;
import org.inmeta.common.process.Event;
import org.inmeta.common.process.TransitionResult;
import org.inmeta.tasksystem.application.result.FundingApplicationDtoMapper;
import org.inmeta.tasksystem.domain.ApplicationRepository;
import org.inmeta.tasksystem.domain.ApplicationSystem;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.inmeta.tasksystem.domain.FundingApplicationFactory;
import org.inmeta.tasksystem.domain.event.CreateApplicationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
@Service
public class TasksystemTransaction {

    @Autowired
    private ApplicationSystem applicationSystem;

    @Autowired
    private ApplicationRepository applicationRepository;

    public ResultMapper<FundingApplication, ?> find(final InputBuilder<Query<Datastore, FundingApplication>> queryInput,
                                                    final ResultMapper<FundingApplication, ?> result) {
        return result.build(applicationRepository.find(queryInput.get()));
    }

    public ResultMapper<FundingApplication, ?> create(final InputBuilder<CreateApplicationEvent> input,
                                                      final FundingApplicationDtoMapper resultMapper) {
        return resultMapper.build(applicationSystem.create(new FundingApplicationFactory(), input.get()));
    }

    public ResultMapper<FundingApplication, ?> submitEvent(final String id,
                                                           final InputBuilder<? extends Event> inputBuilder,
                                                           final ResultMapper<FundingApplication, ?> result) {
        FundingApplication task = applicationRepository.findById(id);
        final TransitionResult transitionResult = applicationSystem.submitEvent(task, inputBuilder.get());
        result.addAllErrors(transitionResult.getErrors());
        task = applicationRepository.save(task);
        return result.build(task);
    }
}
