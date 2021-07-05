package com.icia.mjcinema.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Member;

@Repository
public class memberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void memberjoin(Member member) {
		sql.insert("ms.memberjoin" , member);		
	}

	public Member memberlogin(String mid) {	
		return sql.selectOne("ms.memberlogin" , mid);
	}

	public String idCheck(String mid) {		
		return sql.selectOne("ms.idcheck" , mid);
	}

}
