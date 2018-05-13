package cn.smp.facade.service;

import cn.smp.facade.entity.User;

public interface UserFacade {

    User getUserById(String id);

    User addUser(User user);
}
