package com.jaisoft.data.jdbc.domain.factory;



import com.jaisoft.data.jdbc.domain.aggregate.AccountAggregate;
import com.jaisoft.data.jdbc.domain.entity.ProfileEntity;
import com.jaisoft.data.jdbc.domain.entity.UserEntity;
import com.jaisoft.data.jdbc.domain.factory.validations.AccountAggregateValidations;


public final class AccountAggregateFactory {

    public static AccountAggregate getInstance(
            UserEntity userEntity, ProfileEntity profileEntity){

        return AccountAggregateValidations.validate(new AccountAggregate(userEntity, profileEntity));
    }
}
