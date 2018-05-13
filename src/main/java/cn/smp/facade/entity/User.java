package cn.smp.facade.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    /**
     * ID
     */
    private String id;
    /**
     * 姓名
     */
    private String name;

}
