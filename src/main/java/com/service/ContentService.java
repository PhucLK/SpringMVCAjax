package com.service;

import java.util.List;

import com.model.Content;

public interface ContentService {

	// List<Content> getAllContentsBy();

	Content getContentById(int id);

	void saveOrUpdate(Content content);

	void deleteContentById(int id);

	List<Content> getAllContentByMemberId(int member_id);
	
	List<Content> searchContent(String text, String text2,int member_id);

	
}
