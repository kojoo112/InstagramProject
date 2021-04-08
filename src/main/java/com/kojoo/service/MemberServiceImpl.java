package com.kojoo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kojoo.dao.MemberDAO;
import com.kojoo.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;

	@Override
	public List<MemberVO> selectMember() throws Exception {
		
		
		return dao.selectMember();
	}

	@Override
	public void register(MemberVO vo) {
		
		dao.register(vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) {
		
		return dao.login(vo);
	}

}
