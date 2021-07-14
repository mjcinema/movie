package com.icia.mjcinema.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.LoginForm;


@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void memberjoin(Member member) {
		sql.insert("ms.memberjoin" , member);		
	}

	public Member memberlogin(String username) {
		return sql.selectOne("ms.memberlogin" , username);
	}

	public String idCheck(String mid) {		
		return sql.selectOne("ms.idcheck" , mid);
	}

	public Member memberview(String mid) {	
		return sql.selectOne("ms.memberview" , mid);
	}

	public List<Member> memberlist() {
		return sql.selectList("ms.memberlist");
	}

	public void updateProfileImage(Member member) {
		sql.update("ms.updateProfileImage", member);
	}


	public Member memberListView(String username) {
		return sql.selectOne("ms.memberlistview" , username);
	}
}