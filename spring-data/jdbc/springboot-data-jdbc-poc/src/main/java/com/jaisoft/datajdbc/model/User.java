package com.jaisoft.datajdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@Table("USERS")
public class User {
    @Id
    @Column("USER_ID")
    int userId;
    @Column("USER_NAME")
    String userName;
    @Column("USER_EMAIL")
    String userEmail;

}
