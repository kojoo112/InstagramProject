package com.kojoo.dao;

import java.util.List;

import com.kojoo.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMember() throws Exception;

}
