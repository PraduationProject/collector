package com.cake.dto;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
public class SensorBH1750Temp {

    public static final String NAME = "BH1750";
    public static final String LI = "Li";

    private String phone;
    private float liUp;
    private float liDown;
    private int status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getLiUp() {
        return liUp;
    }

    public void setLiUp(float liUp) {
        this.liUp = liUp;
    }

    public float getLiDown() {
        return liDown;
    }

    public void setLiDown(float liDown) {
        this.liDown = liDown;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SensorBH1750Temp{" +
                "phone='" + phone + '\'' +
                ", liUp=" + liUp +
                ", liDown=" + liDown +
                ", status=" + status +
                '}';
    }
}
