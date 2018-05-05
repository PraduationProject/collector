package com.cake.dao;

import com.cake.entity.SensorInfo;

import java.util.List;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:10:19
 * Email:971661949@qq.com
 */

public interface SensorInfoDao {
    public List<String> loadAllAddr() throws Exception;

    public List<SensorInfo> loadAllInfo() throws Exception;
}