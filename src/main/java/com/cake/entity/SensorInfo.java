package com.cake.entity;


import lombok.Data;

@Data
public class SensorInfo {
    private Long id;
    private String sensor_name;
    private String sensor_addr;
    private String phone;
    private java.sql.Timestamp create_time;
    private java.sql.Timestamp modify_time;
    private Long status;
}
