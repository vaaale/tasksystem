package org.inmeta.tasksystem.controller;

import org.inmeta.common.action.ResultMapper;
import org.inmeta.tasksystem.application.TasksystemTransaction;
import org.inmeta.tasksystem.application.dto.ApplicantDto;
import org.inmeta.tasksystem.application.dto.FundingApplicationDto;
import org.inmeta.tasksystem.application.input.CreateApplication;
import org.inmeta.tasksystem.application.input.ListQueryBuilder;
import org.inmeta.tasksystem.application.input.UpdateApplication;
import org.inmeta.tasksystem.application.result.FundingApplicationDtoMapper;
import org.inmeta.tasksystem.domain.FundingApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 13.04.13
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ApplicationController {

    @Autowired
    private TasksystemTransaction tasksystemTransaction;

    @RequestMapping(value = "/api/application", method = RequestMethod.GET)
    public ResponseEntity<?> list() {
        final ResultMapper<FundingApplication, ?> resultMapper = tasksystemTransaction.find(
                new ListQueryBuilder(),
                new FundingApplicationDtoMapper());

        return new ResponseEntity<Object>(resultMapper.getResultList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/application", method = RequestMethod.PUT)
    public ResponseEntity<?> create(@RequestBody final ApplicantDto applicant) {
        ResultMapper<FundingApplication, ?> result = tasksystemTransaction.create(new CreateApplication(applicant),
                new FundingApplicationDtoMapper());
        return new ResponseEntity<Object>(result.getSingleResult(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/application/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> fetch(@PathVariable("id") final String id) {
        final ResultMapper<FundingApplication, ?> resultMapper = tasksystemTransaction.find(
                new ListQueryBuilder(id),
                new FundingApplicationDtoMapper());

        return new ResponseEntity<Object>(resultMapper.getSingleResult(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/application/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> update(@PathVariable("id") final String id,
                                    @RequestBody final FundingApplicationDto applicationDto) {
            final ResultMapper<FundingApplication, ?> result = tasksystemTransaction.submitEvent(id,
                new UpdateApplication(applicationDto),
                new FundingApplicationDtoMapper());

        return new ResponseEntity<Object>(result.getSingleResult(), HttpStatus.OK);
    }

    @RequestMapping(value = "/api/application/{id}/applicant", method = RequestMethod.POST)
    public ResponseEntity<?> setApplicant(@PathVariable("id") final String id,
                                          @RequestBody final ApplicantDto applicant) {
        final ResultMapper<FundingApplication, ?> result = tasksystemTransaction.submitEvent(id,
                new CreateApplication(applicant),
                new FundingApplicationDtoMapper());

        return new ResponseEntity<Object>(result.getSingleResult(), HttpStatus.OK);
    }



    @RequestMapping(value = "/api/application/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") final Long id) {

        return new ResponseEntity<Object>("", HttpStatus.OK);
    }

}
