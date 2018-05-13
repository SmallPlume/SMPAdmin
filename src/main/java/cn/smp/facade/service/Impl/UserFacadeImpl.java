package cn.smp.facade.service.Impl;

import cn.smp.facade.entity.User;
import cn.smp.facade.service.UserFacade;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Cacheable(cacheNames = "users", key = "#id")
    @Override
    public User getUserById(String id) {
        User user = new User();
        user.setId(id);
        user.setName("name" + id);
        return user;
    }

    @Override
    public User addUser(User user) {
        return null;
    }
}
