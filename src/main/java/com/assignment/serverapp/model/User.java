package com.assignment.serverapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @TableGenerator(name = "Emp_Gen",
            table = "ID_GEN",
            pkColumnName = "GEN_NAME",
            valueColumnName = "GEN_VAL",
            pkColumnValue = "Emp_Gen",
            initialValue = 10000,
            allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator = "Emp_Gen")
    private int id;
    @Column(unique = true)
    private String userName;
    private String password;
    private boolean active;
    private String roles;
}
