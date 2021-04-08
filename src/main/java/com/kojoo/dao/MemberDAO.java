package com.kojoo.dao;

import java.util.List;

import com.kojoo.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMember();
	
	public void register(MemberVO vo);
	
	public MemberVO login(MemberVO vo);

}
