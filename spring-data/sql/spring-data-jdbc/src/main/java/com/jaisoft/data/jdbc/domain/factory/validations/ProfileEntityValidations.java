package com.jaisoft.data.jdbc.domain.factory.validations;

import javax.validation.*;

import com.jaisoft.data.jdbc.domain.entity.ProfileEntity;

import java.util.Set;

public class ProfileEntityValidations {

    static public ProfileEntity validate(ProfileEntity profileEntity){

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<ProfileEntity>> violations = validator.validate(profileEntity);

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
        return profileEntity;
    }
}
