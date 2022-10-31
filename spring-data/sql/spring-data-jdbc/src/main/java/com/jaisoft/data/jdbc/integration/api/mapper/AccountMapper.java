package com.jaisoft.data.jdbc.integration.api.mapper;

import org.dozer.DozerBeanMapper;

import com.jaisoft.data.jdbc.domain.aggregate.AccountAggregate;
import com.jaisoft.data.jdbc.integration.api.dto.request.CreateAccountRequest;
import com.jaisoft.data.jdbc.integration.api.dto.response.CreateAccountResponse;

public class AccountMapper {

    public static AccountAggregate createAccountRequestToAccountAggregate(CreateAccountRequest createAccountRequest){
        DozerBeanMapper mapper= new DozerBeanMapper();
         return mapper.map(createAccountRequest, AccountAggregate.class);
    }

    public static CreateAccountResponse accountAggregateToCreateAccountResponse (AccountAggregate accountAggregate){
        DozerBeanMapper mapper= new DozerBeanMapper();
        return mapper.map(accountAggregate, CreateAccountResponse.class);
    }
}
