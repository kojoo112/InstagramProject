package com.kojoo.service;

import com.kojoo.dao.MemberDAO;
import com.kojoo.vo.MemberVO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO dao;
	
	/**
	 *  method
	 */

	@Override
	public void register(MemberVO vo) {
		dao.register(vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) {
		return dao.login(vo);
	}

	@Override
	public MemberVO read(MemberVO vo) {
		return dao.read(vo);
	}

}
