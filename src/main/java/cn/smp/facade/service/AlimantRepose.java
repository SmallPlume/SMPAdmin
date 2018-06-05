package cn.smp.facade.service;

import cn.smp.facade.entity.Animals;

/**
 * Created by fxiao
 * on 2018/6/5
 */
public interface AlimantRepose<T extends Animals> {

    public void say();

    T getBack(T t);
}
