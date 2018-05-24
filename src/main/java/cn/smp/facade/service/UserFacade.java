package cn.smp.facade.service;

import cn.smp.facade.entity.User;

public interface UserFacade {

    /**
     * 保存
     * @param user
     * @return
     */
    User insert(User user);

    /**
     * 根据手机号查询
     * @param phone
     * @return
     */
    User findByPhone(String phone);

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User getUserById(int id);
}
