package com.icia.mjcinema.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mjcinema.domain.Member;
import com.icia.mjcinema.dto.pageDTO;

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

	public Member memberview(String mid) {	
		return sql.selectOne("ms.memberview" , mid);
	}

	public List<Member> memberlist() {
		return sql.selectList("ms.memberlist");
	}

	

}
