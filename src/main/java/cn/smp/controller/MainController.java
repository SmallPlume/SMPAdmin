package cn.smp.controller;

import cn.smp.facade.entity.Animals;
import cn.smp.facade.entity.Dog;
import cn.smp.facade.service.AlimantRepose;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fxiao
 * on 2018/6/2
 */
@RestController
@RequestMapping("/v1")
@Slf4j
public class MainController {

    @Autowired
    private List<AlimantRepose> alimantReposes;

    @RequestMapping("/login")
    public ModelAndView login() {
        for (AlimantRepose alimantRepose : alimantReposes) {
            alimantRepose.say();
            Animals animals = alimantRepose.getBack(new Animals());
            log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<" + animals.toString()+ ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/login");
        return modelAndView;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home/index");
        return modelAndView;
    }

}
