package com.icia.mjcinema.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.dto.Member;

@Repository
public class memberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void memberjoin(Member member) {
		sql.insert("ms.memberjoin" , member);		
	}

	public String memberlogin(Member member) {	
		return sql.selectOne("ms.memberlogin" , member);
	}

	public String idCheck(String mid) {		
		return sql.selectOne("ms.idcheck" , mid);
	}

}
