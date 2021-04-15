package com.kojoo.service;

import java.util.List;

import com.kojoo.vo.MemberVO;

public interface MemberService {
	
	public List<MemberVO> selectMember() throws Exception;
	
	public void register(MemberVO vo);
	
	
	public MemberVO login(MemberVO vo);
	
	public MemberVO read(MemberVO vo);
}
