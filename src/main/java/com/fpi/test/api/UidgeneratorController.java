package com.fpi.test.api;

import com.github.wujun234.uid.UidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/uidgenerator")
public class UidgeneratorController {

    @Autowired
    private UidGenerator cachedUidGenerator;

    @GetMapping
    public Long getUid(){
        return cachedUidGenerator.getUID();
    }

}
