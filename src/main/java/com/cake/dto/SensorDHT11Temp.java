package com.cake.dto;

import lombok.Data;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
@Data
public class SensorDHT11Temp {

    public static final String NAME = "DHT11";
    public static final String TE = "Te";
    public static final String HU = "Hu";

    private String phone;
    private float teUp;
    private float teDown;
    private float huUp;
    private float huDown;
    private int status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getTeUp() {
        return teUp;
    }

    public void setTeUp(float teUp) {
        this.teUp = teUp;
    }

    public float getTeDown() {
        return teDown;
    }

    public void setTeDown(float teDown) {
        this.teDown = teDown;
    }

    public float getHuUp() {
        return huUp;
    }

    public void setHuUp(float huUp) {
        this.huUp = huUp;
    }

    public float getHuDown() {
        return huDown;
    }

    public void setHuDown(float huDown) {
        this.huDown = huDown;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
