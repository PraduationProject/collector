package com.cake.service;

import com.cake.dto.SensorAddrTemp;
import com.cake.entity.SensorInfo;

import java.util.List;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:10:48
 * Email:971661949@qq.com
 */
public interface SensorInfoService {
    public List<SensorAddrTemp> loadAllAddr() throws Exception;

    public List<SensorInfo> loadAllInfo() throws Exception;
}
