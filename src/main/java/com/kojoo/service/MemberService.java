package com.kojoo.service;

import java.util.List;

import com.kojoo.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> selectMember() throws Exception;
}
