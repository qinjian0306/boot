package com.qj.springboot.bean;

import com.fasterxml.jackson.annotation.JsonView;
import com.qj.springboot.jsonview.UserJson;
import com.qj.springboot.jsonview.View;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserTest implements Serializable {

    @JsonView(View.Public.class)
    private Long id;
    @JsonView(Username.class)
    private String username;
    @JsonView(Password.class)
    private String password;
    @JsonView(User.class)
    private String phone;
    @JsonView(User.class)
    private String email;
    @JsonView(View.Public.class)
    private Date created;
    @JsonView(View.Public.class)
    private Date updated;

    /**
     * 视图
     */
    public interface Username extends View.Public{}
    public interface Password extends View.Public{}
    public interface User extends Username,Password {}

}