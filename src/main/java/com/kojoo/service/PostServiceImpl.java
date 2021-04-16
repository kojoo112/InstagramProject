package com.kojoo.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kojoo.dao.PostDAO;
import com.kojoo.vo.MemberVO;
import com.kojoo.vo.PostVO;

@Service
public class PostServiceImpl implements PostService {

	@Inject
	private PostDAO dao;
	
	@Override
	public void register(PostVO pvo) {
		dao.register(pvo);
	}

	@Override
	public List<PostVO> myPosting(MemberVO mvo) {
		
		return dao.myPosting(mvo);
	}

}
