package com.kojoo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kojoo.dao.PostDAO;
import com.kojoo.vo.LikeVO;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {

	@Inject
	private PostDAO dao;
	
	@Override
	public void register(PostVO postVo) {
		dao.register(postVo);
	}

	@Override
	public List<PostVO> myPosting(MemberVO memberVo) {
		return dao.myPosting(memberVo);
	}

	@Override
	public List<PostVO> feedReading(MemberVO memberVo) {
		return dao.feedReading(memberVo);
	}
	
	@Override
	public List<LikeVO> likeSelect(MemberVO memberVo){
		return dao.likeSelect(memberVo);
	}

	@Override
	public void likeInsert(LikeVO likeVo) {
		dao.likeInsert(likeVo);
	}

	@Override
	public int getLikeCount(LikeVO likeVo) {
		return dao.getLikeCount(likeVo);
	}

	@Override
	public void deleteLike(LikeVO likeVo) {
		dao.deleteLike(likeVo);
	}

	@Override
	public int postLikeCount(LikeVO likeVo) {
		return dao.postLikeCount(likeVo);
	}

}
