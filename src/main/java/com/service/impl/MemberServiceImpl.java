package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Member;
import com.repository.MemberRepository;
import com.service.MemberSerive;

@Service
public class MemberServiceImpl implements MemberSerive {

	@Autowired
	MemberRepository memberRepository;

	@Override
	public Member getMemberById(int id) {
		// TODO Auto-generated method stub
		return memberRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(Member member) {
		// TODO Auto-generated method stub
		memberRepository.save(member);
	}

	@Override
	public Member getMemberByUsername(String username) {
		// TODO Auto-generated method stub
		return memberRepository.findByuserName(username);
	}

}
