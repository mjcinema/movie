package com.icia.mjcinema.service;

import com.icia.mjcinema.domain.Authority;
import com.icia.mjcinema.domain.User;
import com.icia.mjcinema.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertTest() {
        User user = User.builder()
                .username("mmm")
                .password("mmm")
                .name("mmm")
                .birth("1999-12-12")
                .email("mmm@mjcinema.github.com")
                .address("address")
                .build();

//        user.getAuthorities().add(new Authority("mevius", "ROLE_ADMIN"));
        userMapper.insertUser(user);

        for (Authority authority : user.getAuthorities()) {
            userMapper.insertAuthority(authority);
        }
    }


}