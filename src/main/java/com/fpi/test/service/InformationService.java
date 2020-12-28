package com.fpi.test.service;

import com.alibaba.fastjson.JSONObject;
import com.fpi.test.model.Infomation;
import org.springframework.stereotype.Service;

@Service
public class InformationService {

    public String saveTest(Infomation infomation){
        System.out.println(infomation);
        JSONObject jsonObject = JSONObject.parseObject(infomation.toString());
        System.out.println(jsonObject.toString());
        System.out.println(JSONObject.toJSONString(infomation));
        return "success";
    }

}
