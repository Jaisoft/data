package com.jaisoft.reactive.repository;

import com.jaisoft.reactive.model.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AccountMongoRepository extends ReactiveMongoRepository<Account, String> {

}
