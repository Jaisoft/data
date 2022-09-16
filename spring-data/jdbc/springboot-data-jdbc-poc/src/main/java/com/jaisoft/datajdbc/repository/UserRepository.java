package com.jaisoft.datajdbc.repository;

import com.jaisoft.datajdbc.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository  extends CrudRepository<User, Integer> {
}
