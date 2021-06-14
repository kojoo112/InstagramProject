package com.kojoo.dao;

import com.kojoo.vo.MemberVO;

public interface MemberDAO {
	
	public void register(MemberVO vo);
	
	public MemberVO login(MemberVO vo);
	
	public MemberVO read(MemberVO vo);
}
