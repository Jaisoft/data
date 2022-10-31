package com.jaisoft.data.jdbc.domain.factory;


import com.jaisoft.data.jdbc.domain.entity.UserEntity;

import com.jaisoft.data.jdbc.domain.factory.validations.UserEntityValidations;

public class UserEntityFactory {

    public static UserEntity getInstance(String userName){

        return UserEntityValidations.validate(new UserEntity(userName));
    }
}
