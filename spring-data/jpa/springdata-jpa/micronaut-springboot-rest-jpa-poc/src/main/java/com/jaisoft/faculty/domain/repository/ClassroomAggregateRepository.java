package com.jaisoft.faculty.domain.repository;


import com.jaisoft.faculty.domain.aggregate.ClassroomAggregate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomAggregateRepository extends JpaRepository<Long, ClassroomAggregate> {
}
