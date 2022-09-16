package jaisoft.data.jdbc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jaisoft.data.jdbc.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByLastName(@Param("lName") String lastName);

    List<Student> findByLastNameIgnoreCase(@Param("lName") String lastName);
}