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

	public void save(User user) {
		sql.insert("UserMapper.save", user);
	}

	public User selectUserByUsername(String username) {
		return sql.selectOne("UserMapper.selectUserByUsername", username);
	}

	public List<User> selectUsers() {
		return sql.selectList("UserMapper.selectUsers");
	}

	public void deleteUser(String username) {
		sql.delete("UserMapper.deleteUser", username);
	}

	public void updateProfileImage(User user) {
		sql.update("ms.updateProfileImage", user);
	}
}
