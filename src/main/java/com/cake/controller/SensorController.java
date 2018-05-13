package com.cake.controller;

import com.alibaba.fastjson.util.IOUtils;
import com.cake.dto.SensorAddrTemp;
import com.cake.entity.SensorInfo;
import com.cake.service.SensorDataService;
import com.cake.service.SensorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by XuRui's Hands.
 * User:XuRui
 * Date:2018/5/4
 * Time:11:05
 * Email:971661949@qq.com
 */

@Controller
@RequestMapping("sensor")
public class SensorController {

    @Autowired
    private SensorInfoService sensorInfoService;

    @Autowired
    private SensorDataService sensorDataService;

    @ResponseBody
    @RequestMapping("loadAllAddr")
    public List<SensorAddrTemp> loadAllSensorAddr() throws Exception {
        return sensorInfoService.loadAllAddr();
    }

    @ResponseBody
    @RequestMapping("loadAllInfo")
    public List<SensorInfo> loadAllSensorInfo() throws Exception {
        return sensorInfoService.loadAllInfo();
    }

    @ResponseBody
    @RequestMapping(value = "/saveData", method = RequestMethod.POST)
    public String saveData(HttpServletRequest request) throws Exception {
        BufferedReader br = request.getReader();
        String body = "", str;
        while ((str = br.readLine()) != null) {
            body += str;
        }

        if (sensorDataService.saveData(body) > 0) {
            return "succeed";
        }

        System.out.println(body);
        return "failed";
    }


}
