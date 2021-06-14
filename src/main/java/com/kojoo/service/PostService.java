package com.kojoo.service;

import java.util.List;

import com.kojoo.vo.LikeVO;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

public interface PostService {

	public void register(PostVO postVo);
	
	public List<PostVO> myPosting(MemberVO memberVo);
	
	public List<PostVO> feedReading(MemberVO memberVo);
	
	public List<LikeVO> likeSelect(MemberVO memberVo);
	
	public void likeInsert(LikeVO likeVo);
	
	public int getLikeCount(LikeVO likeVo);
	
	public void deleteLike(LikeVO likeVo);
	
	public int postLikeCount(LikeVO likeVo);
}
