package com.kojoo.dao;

import java.util.List;
import java.util.Map;

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
	public List<MemberVO> selectMember() {
		
		return session.selectList(namespace+".selectMember");
	}

	@Override
	public void register(MemberVO vo) {
		session.insert(namespace+".register", vo);
	}

	@Override
	public MemberVO login(MemberVO vo) {
		
		return session.selectOne(namespace + ".login", vo);
	}

	@Override
	public void saveImage(Map<String, Object> hmap) {
	    session.insert(namespace + ".saveImage",hmap);
	}
	
	public Map<String, Object> getByteImage() {
	    return session.selectOne(namespace + ".getByteImage");
	}

	@Override
	public MemberVO read(MemberVO vo) {
		
		return session.selectOne(namespace + ".read", vo);
	}
}
