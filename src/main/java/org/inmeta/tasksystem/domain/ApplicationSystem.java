package org.inmeta.tasksystem.domain;

import org.inmeta.common.action.Factory;
import org.inmeta.common.process.Context;
import org.inmeta.common.process.Event;
import org.inmeta.common.process.EventDriven;
import org.inmeta.common.process.EventSystem;
import org.inmeta.common.process.TransitionResult;
import org.inmeta.tasksystem.domain.process.FundingApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:07
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ApplicationSystem implements EventSystem<FundingApplication>, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public TransitionResult submitEvent(final EventDriven<FundingApplication> process, final Event event) {
        final TransitionResult result = process.setExecutor(
                getExecutor(process))
                .handleEvent(event);
        return result;
    }

    private Context<? extends FundingApplication> getExecutor(final EventDriven<FundingApplication> process) {
        return new FundingApplicationContext(applicationContext);
    }


    @Override
    public FundingApplication create(final Factory<FundingApplication> factory, final Event event) {
        FundingApplication task = applicationRepository.save(factory.create());
        final TransitionResult transitionResult = task.setExecutor(getExecutor(task)).handleEvent(event);
        task = applicationRepository.save(task);
        if (transitionResult.hasError()) {
            throw new IllegalArgumentException("Unable to create application.");
        }
        return task;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
