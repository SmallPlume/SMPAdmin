package cn.smp.facade.service;

import cn.smp.facade.entity.Animals;
import cn.smp.facade.entity.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by fxiao
 * on 2018/6/5
 */
@Component
@Slf4j
public class CatReposeImpl implements CatRepose {

    @Override
    public void say() {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<this is cat>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public Animals getBack(Animals cat) {
        cat.setAge(12);
        cat.setName("小猫");
        return cat;
    }
}
