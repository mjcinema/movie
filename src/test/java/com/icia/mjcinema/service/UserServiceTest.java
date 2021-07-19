package com.icia.mjcinema.service;

import com.icia.mjcinema.domain.Authority;
import com.icia.mjcinema.domain.User;
import com.icia.mjcinema.dto.RegistrationForm;
import com.icia.mjcinema.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

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

        userMapper.insertUser(user);

        for (Authority authority : user.getAuthorities()) {
            userMapper.insertAuthority(authority);
        }
    }

    @Test
    public void getUserByUsername() {

        User user = insertUser();

        User other = userService.getUserByUsername(user.getUsername());

        assertThat(other.getUsername()).isEqualTo(user.getUsername());
        assertThat(other.getAuthorities()).hasSize(1);
        assertThat(other.getAuthorities().get(0).getAuthority()).isEqualTo("ROLE_USER");
    }

    private User insertUser() {
        User user = User.builder()
                .username("mmm")
                .password("mmm")
                .name("mmm")
                .birth("1999-12-12")
                .email("mmm@mjcinema.github.com")
                .address("address")
                .build();

        userMapper.insertUser(user);

        for (Authority authority : user.getAuthorities()) {
            userMapper.insertAuthority(authority);
        }

        return user;
    }

    @Test
    @Rollback(false)
    public void UserService_join() {
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setUsername("mevius");
        registrationForm.setPassword("mevius");
        registrationForm.setName("mevius");
        registrationForm.setAddress("mevius address");
        registrationForm.setEmail("mevius@naver.com");
        registrationForm.setBirth("1999-09-09");

        User user = userService.join(registrationForm);

    }
}