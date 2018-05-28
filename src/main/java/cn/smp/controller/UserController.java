package cn.smp.controller;

import cn.smp.facade.entity.User;
import cn.smp.facade.service.UserFacade;
import cn.smp.support.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @RequestMapping("/add")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        log.info("add request");
        modelAndView.addObject("email", "123456@abc.com");
        modelAndView.setViewName("user/add");
        return modelAndView;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/insert")
    public Result insertUser(@Validated(User.INSERT.class) @RequestBody User user){
        return Result.ok(userFacade.insert(user));
    }




}
