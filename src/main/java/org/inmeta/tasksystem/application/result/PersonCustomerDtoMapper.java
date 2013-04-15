package org.inmeta.tasksystem.application.result;

import org.apache.commons.collections.CollectionUtils;
import org.inmeta.common.action.ResultMapper;
import org.inmeta.tasksystem.application.dto.CustomerDto;
import org.inmeta.tasksystem.integrations.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexanderv
 * Date: 15.04.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class PersonCustomerDtoMapper extends ResultMapper<Person, CustomerDto> {
    private List<CustomerDto> result = new ArrayList<CustomerDto>();

    @Override
    public ResultMapper<Person, CustomerDto> build(final Person p) {
        p.id = 0L;
        result.add(map(p));
        return this;
    }

    @Override
    public ResultMapper<Person, CustomerDto> build(final Collection<Person> list) {
        if(CollectionUtils.isNotEmpty(list)) {
            long i = 0;
            for(Person p : list) {
                p.id = i++;
                result.add(map(p));
            }
        }
        return this;
    }

    private CustomerDto map(final Person p) {
        final CustomerDto dto = new CustomerDto();
        dto.setId(p.id.toString());
        dto.setArea(p.area);
        dto.setRealFistName(p.realFistName);
        dto.setRealLastName(p.realLastName);
        dto.setStreet(p.street);
        dto.setZipCode(p.zipCode);

        return dto;
    }

    @Override
    public List<CustomerDto> getResultList() {
        return result;
    }

    @Override
    public CustomerDto getSingleResult() {
        if(CollectionUtils.isNotEmpty(result)) {
            return result.get(0);
        }
        return null;
    }
}
