package com.jaisoft.data.jdbc.domain.factory.validations;


import javax.validation.*;

import com.jaisoft.data.jdbc.domain.entity.UserEntity;

import java.util.Set;

public class UserEntityValidations {

    static public UserEntity validate(UserEntity userEntity){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(userEntity);

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        return userEntity;
    }
}
