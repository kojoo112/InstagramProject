package com.kojoo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kojoo.vo.LikeVO;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

@Repository
public class PostDAOImpl implements PostDAO{

	@Inject
	SqlSession session;
	
	private static String namespace = "com.kojoo.mapper.postMapper";
	
	@Override
	public void register(PostVO postVo) {
		session.insert(namespace + ".register", postVo);
	}

	@Override
	public List<PostVO> myPosting(MemberVO memberVo) {
		return session.selectList(namespace + ".myPosting", memberVo);
	}

	@Override
	public List<PostVO> feedReading(MemberVO memberVo) {
		return session.selectList(namespace + ".feedReading", memberVo);
	}

	@Override
	public List<LikeVO> likeSelect(MemberVO memberVo) {
		return session.selectList(namespace + ".likeSelect", memberVo);
	}

	@Override
	public void likeInsert(LikeVO likeVo) {
		session.insert(namespace + ".likeInsert", likeVo);
	}

	@Override
	public int getLikeCount(LikeVO likeVo) {
		return session.selectOne(namespace +".getLikeCount", likeVo);
	}

	@Override
	public void deleteLike(LikeVO likeVo) {
		session.delete(namespace + ".deleteLike", likeVo);
	}

	@Override
	public int postLikeCount(LikeVO likeVo) {
		return session.selectOne(namespace + ".postLikeCount", likeVo);
	}
	
	

}
