package com.jaisoft.data.jdbc.domain.factory;

import com.jaisoft.data.jdbc.domain.entity.ProfileEntity;
import com.jaisoft.data.jdbc.domain.factory.validations.ProfileEntityValidations;

public class ProfileEntityFactory {

    public static ProfileEntity getInstance(String profileName){

        return ProfileEntityValidations.validate(new ProfileEntity(profileName));
    }
}
