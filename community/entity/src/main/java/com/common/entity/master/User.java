package com.common.entity.master;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author yanhan
 * @Auther: yanhan
 * @Date: 2018/8/29 17:04
 * @Description:
 */
@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7216388290420703574L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    private  String sex;

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
