package com.cake.entity;

import lombok.Data;

@Data
public class Employee {
    private Long id;
    private String manager_name;
    private String phone;
    private Long privilege;
    private java.sql.Timestamp create_time;
    private java.sql.Timestamp modify_time;
    private Long status;
}
