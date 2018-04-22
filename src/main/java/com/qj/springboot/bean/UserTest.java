package com.qj.springboot.bean;

import com.fasterxml.jackson.annotation.JsonView;
import com.qj.springboot.jsonview.View;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserTest implements Serializable {

    @JsonView(View.Common.class)
    private Long id;
    @JsonView(View.Common.class)
    private String username;
    @JsonView(View.Common.class)
    private String password;
    @JsonView(View.Ext.class)
    private String phone;
    @JsonView(View.Ext.class)
    private String email;
    @JsonView(View.Deal.class)
    private Date created;
    @JsonView(View.Deal.class)
    private Date updated;

}