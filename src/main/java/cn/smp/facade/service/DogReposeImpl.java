package cn.smp.facade.service;

import cn.smp.facade.entity.Animals;
import cn.smp.facade.entity.Dog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by fxiao
 * on 2018/6/5
 */
@Component
@Slf4j
public class DogReposeImpl implements DogRepose {

    @Override
    public void say() {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<this is dog>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public Animals getBack(Animals dog) {
        dog.setAge(11);
        dog.setName("小狗");
        return dog;
    }
}
