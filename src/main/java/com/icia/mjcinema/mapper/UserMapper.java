package com.icia.mjcinema.mapper;

import java.util.List;

import com.icia.mjcinema.domain.Authority;
import com.icia.mjcinema.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
	List<User> getUsers();
	User getUserById(Long id);
	User getUserByUsername(String username);

	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(String username);

	void updateImage(User user);

	void insertAuthority(Authority authority);
}
