package com.fpi.test.api;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nacos")
public class NacosController {

    @NacosValue(value = "${firsttest:default}",autoRefreshed = true)
    private String firsttest;

    @GetMapping
    public String getFirsttest(){
        return firsttest;
    }
}
