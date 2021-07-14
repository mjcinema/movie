package com.icia.mjcinema.dao;

import java.util.List;

import com.icia.mjcinema.domain.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserDao {

	@Autowired
	private SqlSessionTemplate sql;

	public List<User> getUsers() {
		return sql.selectList("UserMapper.getUsers");
	}

	public User getUserById(Long id) {
		return sql.selectOne("UserMapper.getUserById", id);
	}

	public User getUserByUsername(String username) {
		return sql.selectOne("UserMapper.getUserByUsername", username);
	}


	public void insertUser(User user) {
		sql.insert("UserMapper.insertUser", user);
	}

	public void updateUser(User user) {
		sql.update("UserMapper.updateUser", user);
	}

	public void deleteUser(String username) {
		sql.delete("UserMapper.deleteUser", username);
	}

	public void updateImage(User user) {
		sql.update("ms.updateProfileImage", user);
	}
}
