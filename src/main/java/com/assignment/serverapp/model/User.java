package com.assignment.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class User {
    @Id
    @TableGenerator(name = "User_Gen",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "User_Gen",
            initialValue = 10000,
            allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "User_Gen")
    private int userId;
    @Column(unique = true)
    private String userName;
    private String fullName;
    private String password;
}
