package org.inmeta.tasksystem.domain;

import org.inmeta.common.action.Factory;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 02:08
 * To change this template use File | Settings | File Templates.
 */
public class FundingApplicationFactory implements Factory<FundingApplication> {

    @Override
    public FundingApplication create() {
        return new FundingApplication();
    }
}
