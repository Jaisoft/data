package com.jaisoft.faculty.domain.aggregate;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ClassroomAggregate {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "clasroom_id", nullable = false)
    private Long clasroomId;
    private String classroomTitle;
    private String classroomResume;
}
