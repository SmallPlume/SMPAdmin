package cn.smp.controller;

import cn.smp.facade.entity.User;
import cn.smp.facade.service.UserFacade;
import cn.smp.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

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
