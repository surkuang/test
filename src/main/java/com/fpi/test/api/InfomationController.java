package com.fpi.test.api;

import com.fpi.test.model.Infomation;
import com.fpi.test.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/information")
@CrossOrigin
public class InfomationController {

    @Autowired
    private InformationService informationService;

    @PostMapping
    public String saveTest(@RequestBody @Validated Infomation infomation){
        return informationService.saveTest(infomation);
    }
}
