package com.qj.springboot.mapper;

import com.qj.springboot.bean.UserTest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserTestMapper {

    List<UserTest> getUserList();

    @Select("select * from user where id = #{id}")
    UserTest getUserById(@Param("id") Integer id);

    @Insert("insert into user(username, password) values(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);

}
