package cn.smp.facade.service.Impl;

import cn.smp.facade.dao.UserRepository;
import cn.smp.facade.entity.User;
import cn.smp.facade.service.UserFacade;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User insert(User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
        return userRepository.save(user);
    }

    @Cacheable(cacheNames = "users", key = "#phone")
    @Override
    public User findByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }

    @Cacheable(cacheNames = "users", key = "#id")
    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}
