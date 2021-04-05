package com.kojoo.instagram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kojoo.instagram.dao.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO dao;

	@Override
	public String getId(String id) {
		return dao.getId(id);
	}

}
