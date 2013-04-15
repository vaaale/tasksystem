package org.inmeta.tasksystem.controller;

import org.inmeta.common.action.ResultMapper;
import org.inmeta.tasksystem.application.CustomerTransaction;
import org.inmeta.tasksystem.application.input.PersonQueryBuilder;
import org.inmeta.tasksystem.application.result.PersonCustomerDtoMapper;
import org.inmeta.tasksystem.integrations.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 15:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CustomerController {
     @Autowired
     private CustomerTransaction customerTransaction;

    @RequestMapping(value = "/api/customer/{name}", method = RequestMethod.GET)
    public ResponseEntity<?> search(@PathVariable("name") final String name) {
        final ResultMapper<Person, ?> resultMapper = customerTransaction.find(
                new PersonQueryBuilder(name),
                new PersonCustomerDtoMapper());

        return new ResponseEntity<Object>(resultMapper.getResultList(), HttpStatus.OK);
    }

}
