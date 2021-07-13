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
	
	public void memberjoin(User user) {
		sql.insert("ms.memberjoin" , user);
	}

	public User memberlogin(String username) {
		return sql.selectOne("ms.memberlogin" , username);
	}

	public String idCheck(String mid) {		
		return sql.selectOne("ms.idcheck" , mid);
	}

	public User memberview(String mid) {
		return sql.selectOne("ms.memberview" , mid);
	}

	public List<User> memberlist() {
		return sql.selectList("ms.memberlist");
	}

	public void updateProfileImage(User user) {
		sql.update("ms.updateProfileImage", user);
	}


	public User memberListView(String username) {
		return sql.selectOne("ms.memberlistview" , username);
	}
}