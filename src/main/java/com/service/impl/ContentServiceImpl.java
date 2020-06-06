package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Content;
import com.repository.ContentRepository;
import com.service.ContentService;

/**
 * @author PhucTV7
 *
 */
@Service
public class ContentServiceImpl implements ContentService {
	
	@Autowired
	ContentRepository contentRepository;

	
	@Override
	public List<Content> getAllContentByMemberId(int member_id) {
		// TODO Auto-generated method stub
		return contentRepository.getAllContentByMemberId(member_id);
	}

	@Override
	public Content getContentById(int id) {
		// TODO Auto-generated method stub
		return contentRepository.findOne(id);
	}

	@Override
	public void saveOrUpdate(Content content) {
		// TODO Auto-generated method stub
		contentRepository.save(content);
	}

	@Override
	public void deleteContentById(int id) {
		// TODO Auto-generated method stub
		contentRepository.delete(id);
	}

	@Override
	public List<Content> searchContent(String text, String text2, int member_id) {
		// TODO Auto-generated method stub
		return contentRepository.searchContent(text, text2, member_id);
	}



}
