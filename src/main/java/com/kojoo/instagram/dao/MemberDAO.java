package com.kojoo.instagram.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {
	public String getId(@Param("id")String id);
}
