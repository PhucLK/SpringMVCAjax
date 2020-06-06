package com.util;

/**
 * @author PhucTV7
 *
 */
public class SQLCommand {
	
	// CONTENT QUERY
	public static final String SELECT_CONTENT_ALL = "SELECT * FROM Content c join Member m on c.member_id = m.id WHERE c.member_id =?";
	public static final String SEARCH_CONTENT = "SELECT c.id,c.brief,c.content,c.createdate,c.sort, c.title, c.updateDate,c.member_id FROM Content c join Member m on c.member_id = m.id WHERE title like ? or brief like ? and c.member_id=?";
	
}
