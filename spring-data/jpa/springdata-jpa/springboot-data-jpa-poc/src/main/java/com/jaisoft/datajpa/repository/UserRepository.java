package com.jaisoft.datajpa.repository;

import com.jaisoft.datajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
