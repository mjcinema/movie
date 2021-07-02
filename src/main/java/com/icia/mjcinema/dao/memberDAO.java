package com.icia.mjcinema.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.dto.memberDTO;

@Repository
public class memberDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void memberjoin(memberDTO member) {
		sql.insert("ms.memberjoin" , member);		
	}

	public String memberlogin(memberDTO member) {	
		return sql.selectOne("ms.memberlogin" , member);
	}

}
