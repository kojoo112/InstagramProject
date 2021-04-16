package com.kojoo.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kojoo.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kojoo.mapper.memberMapper";
	
	/**
	 *  method
	 */

	@Override
	public void register(MemberVO vo) {
		session.insert(namespace+".register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		
		return session.selectOne(namespace + ".login", vo);
	}


	@Override
	public MemberVO read(MemberVO vo) {
		
		return session.selectOne(namespace + ".read", vo);
	}
}
