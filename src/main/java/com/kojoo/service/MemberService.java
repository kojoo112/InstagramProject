package com.kojoo.service;

import com.kojoo.vo.MemberVO;

public interface MemberService {
	
	public void register(MemberVO vo);

	public MemberVO login(MemberVO vo);
	
	public MemberVO read(MemberVO vo);
}
