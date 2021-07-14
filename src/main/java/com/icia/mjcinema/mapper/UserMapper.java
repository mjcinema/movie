package com.icia.mjcinema.mapper;

import java.util.List;

import com.icia.mjcinema.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
	public List<User> getUsers();
	public User getUserById(Long id);
	public User getUserByUsername(String username);

	public void insertUser(User user);
	public void updateUser(User user);
	public void deleteUser(String username);
	public void updateImage(User user);
}
