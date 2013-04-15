package org.inmeta.tasksystem.domain.process;

import org.inmeta.common.process.Context;
import org.inmeta.common.process.StateAction;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.springframework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:02
 * To change this template use File | Settings | File Templates.
 */
public class FundingApplicationContext implements Context {
    private Map<Handlers, StateAction<FundingApplication>> handlers = new HashMap<Handlers, StateAction<FundingApplication>>();
    private ApplicationContext context;

    public FundingApplicationContext(final ApplicationContext context) {
        this.context = context;

        handlers.put(Handlers.CREATE, new CreateApplicationHandler());
        handlers.put(Handlers.UPDATE_APPLICATION, new UpdateApplicationHandler());
    }

    @Override
    public StateAction lookupAction(final String code) {
        return handlers.get(Handlers.valueOf(code));
    }
}
