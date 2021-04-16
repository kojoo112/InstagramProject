package com.kojoo.dao;

import java.util.List;

import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

public interface PostDAO {
	
	public void register(PostVO pvo);
	
	public List<PostVO> myPosting(MemberVO mvo);
}
