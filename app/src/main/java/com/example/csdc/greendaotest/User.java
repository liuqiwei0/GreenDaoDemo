package com.example.csdc.greendaotest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by csdc on 2019/1/27.
 */
@Entity
public class User {

    @Id
    private Long id;
    @Property(nameInDb = "USERNAME")
    private String userName;
    @Property(nameInDb = "NICKNAME")
    private String nickName;
    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 537398234)
    public User(Long id, String userName, String nickName) {
        this.id = id;
        this.userName = userName;
        this.nickName = nickName;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
