package com.kojoo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kojoo.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.kojoo.mapper.memberMapper";

	@Override
	public List<MemberVO> selectMember() {
		
		return session.selectList(namespace+".selectMember");
	}
}
