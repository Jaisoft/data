package jaisoft.data.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    private Integer enrollmentYear;
}