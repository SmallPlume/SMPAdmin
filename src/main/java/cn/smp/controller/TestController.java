package cn.smp.controller;

import cn.smp.facade.service.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/smp")
public class TestController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping("/test")
    public String Test() {
        userFacade.getUserById(1);
        return "test11";
    }
}
