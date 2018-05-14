package cn.smp.facade.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity(name = "s_user")
@NamedQuery(name = "User.findById", query = "select u.id,u.name,u.phone from s_user u where u.id = ?1")
public class User implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "用户ID不能为空", groups = {UPDATE.class})
    private int id;
    /**
     * 姓名
     */
    @NotNull(message = "用户名称不能为空", groups = {INSERT.class, UPDATE.class})
    private String name;
    /**
     * 密码
     */
    @NotNull(message = "用户密码不能为空", groups = {INSERT.class})
    private String password;
    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空", groups = {INSERT.class, UPDATE.class})
    private String phone;

    public interface INSERT {}

    public interface UPDATE {}

}
