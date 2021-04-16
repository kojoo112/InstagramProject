package com.kojoo.service;

import java.util.List;

import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

public interface PostService {

	public void register(PostVO request);
	
	public List<PostVO> myPosting(MemberVO mvo);
}
