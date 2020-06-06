package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Content;
import com.util.SQLCommand;

public interface ContentRepository extends JpaRepository<Content, Integer> {

	@Query(value = SQLCommand.SELECT_CONTENT_ALL, nativeQuery = true)
	List<Content> getAllContentByMemberId(int member_id);

	@Query(value = SQLCommand.SEARCH_CONTENT, nativeQuery = true)
	List<Content> searchContent(String text,String text2,int member_id);
}
