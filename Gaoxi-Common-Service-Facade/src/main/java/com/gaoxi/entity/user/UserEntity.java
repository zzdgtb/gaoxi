package com.gaoxi.entity.user;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/7.
 */
@Data
@Table(name = "u_user")
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * name
     */
    @Column(name = "name")
    private String name;

    /**
     * owner_account
     */
    @Column(name = "phone")
    private String phone;

    /**
     * owner_account_id
     */
    @Column(name = "nick_name")
    private String nickName;


}

