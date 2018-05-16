package com.cake.service.impl;

import com.cake.dao.SensorInfoDao;
import com.cake.dto.SensorAddrTemp;
import com.cake.entity.SensorInfo;
import com.cake.service.SensorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:10:48
 * Email:971661949@qq.com
 */

@Service
public class SensorInfoServiceImpl implements SensorInfoService {

    @Autowired
    private SensorInfoDao sensorInfoDao;

    @Transactional
    public List<SensorAddrTemp> loadAllAddr() throws Exception {
        return sensorInfoDao.loadAllAddr();
    }

    @Transactional
    public List<SensorInfo> loadAllInfo() throws Exception {
        return sensorInfoDao.loadAllInfo();
    }

    public void updatePhone(String sensorName, String phone) throws Exception {
        sensorInfoDao.updatePhone(sensorName, phone);
    }

}
