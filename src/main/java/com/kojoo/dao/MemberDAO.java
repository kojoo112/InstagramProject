package com.kojoo.dao;

import java.util.List;
import java.util.Map;

import com.kojoo.vo.MemberVO;

public interface MemberDAO {
	
	public List<MemberVO> selectMember();
	
	public void register(MemberVO vo);
	
	public MemberVO login(MemberVO vo);
	
	public MemberVO read(MemberVO vo);
	
	public void saveImage(Map<String, Object> hmap);

	public Map<String, Object> getByteImage();

}
