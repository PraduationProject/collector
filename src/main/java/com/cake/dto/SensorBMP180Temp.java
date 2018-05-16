package com.cake.dto;

/**
 * Created by xiaoyiyun on 2018/5/16.
 */
public class SensorBMP180Temp {

    public static final String NAME = "BMP180";
    public static final String PR = "Pr";
    public static final String TE = "Te";
    public static final String HI = "Hi";

    private String phone;
    private float prUp;
    private float prDown;
    private float teUp;
    private float teDown;
    private float hiUp;
    private float hiDown;
    private int status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getPrUp() {
        return prUp;
    }

    public void setPrUp(float prUp) {
        this.prUp = prUp;
    }

    public float getPrDown() {
        return prDown;
    }

    public void setPrDown(float prDown) {
        this.prDown = prDown;
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

    public float getHiUp() {
        return hiUp;
    }

    public void setHiUp(float hiUp) {
        this.hiUp = hiUp;
    }

    public float getHiDown() {
        return hiDown;
    }

    public void setHiDown(float hiDown) {
        this.hiDown = hiDown;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SensorBMP180Temp{" +
                "phone='" + phone + '\'' +
                ", prUp=" + prUp +
                ", prDown=" + prDown +
                ", teUp=" + teUp +
                ", teDown=" + teDown +
                ", hiUp=" + hiUp +
                ", hiDown=" + hiDown +
                ", status=" + status +
                '}';
    }
}
