package cn.smp.facade.dao;

import cn.smp.facade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByPhone(String phone);
}
