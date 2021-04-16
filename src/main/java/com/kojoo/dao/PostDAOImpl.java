package com.kojoo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

@Repository
public class PostDAOImpl implements PostDAO{

	@Inject
	SqlSession session;
	
	private static String namespace = "com.kojoo.mapper.postMapper";
	
	@Override
	public void register(PostVO pvo) {
		session.insert(namespace + ".register", pvo);
		
	}

	@Override
	public List<PostVO> myPosting(MemberVO mvo) {
		
		return session.selectList(namespace + ".myPosting", mvo);
	}

}
