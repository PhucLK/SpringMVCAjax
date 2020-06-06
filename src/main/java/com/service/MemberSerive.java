package com.service;

import com.model.Member;

public interface MemberSerive {
	
	void saveOrUpdate(Member member);
	
	Member getMemberByUsername(String name);

	Member getMemberById(int id);
}
