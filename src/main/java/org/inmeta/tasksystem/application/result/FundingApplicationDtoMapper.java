package org.inmeta.tasksystem.application.result;


import org.apache.commons.collections.CollectionUtils;
import org.inmeta.common.action.ResultMapper;
import org.inmeta.tasksystem.application.dto.FundingApplicationDto;
import org.inmeta.tasksystem.domain.Applicant;
import org.inmeta.tasksystem.domain.FundingApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 14.04.13
 * Time: 01:34
 * To change this template use File | Settings | File Templates.
 */
public class FundingApplicationDtoMapper extends ResultMapper<FundingApplication, FundingApplicationDto> {
    private List<FundingApplicationDto> result = new ArrayList<FundingApplicationDto>();

    @Override
    public ResultMapper<FundingApplication, FundingApplicationDto> build(final FundingApplication application) {
        result.add(map(application));

        return this;
    }

    @Override
    public ResultMapper<FundingApplication, FundingApplicationDto> build(final Collection<FundingApplication> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            for (FundingApplication app : list) {
                result.add(map(app));
            }
        }
        return this;
    }

    private FundingApplicationDto map(final FundingApplication app) {
        FundingApplicationDto dto = new FundingApplicationDto();
        final Applicant applicant = app.getApplicant();
        dto.setId(app.getId().toString());
        dto.setState(app.getState().toString());
        if (null != applicant) {
            dto.setAccountNumber(applicant.getAccountNumber());
            dto.setEmail(applicant.getEmail());
            dto.setName(applicant.getName());
        }

        dto.setDescription(app.getDescription());
        dto.setMemberships(app.getMemberships());

        return dto;
    }

    @Override
    public List<FundingApplicationDto> getResultList() {
        return result;
    }

    @Override
    public FundingApplicationDto getSingleResult() {
        if (CollectionUtils.isNotEmpty(result)) {
            return result.get(0);
        }
        return null;
    }
}
