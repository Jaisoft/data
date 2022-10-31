package com.jaisoft.data.jdbc.domain.factory.validations;

import javax.validation.*;

import com.jaisoft.data.jdbc.domain.aggregate.AccountAggregate;

import java.util.Set;

public final class AccountAggregateValidations {

    static public AccountAggregate validate(AccountAggregate accountAggregate){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<AccountAggregate>> violations = validator.validate(accountAggregate);

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        return accountAggregate;
    }
}
