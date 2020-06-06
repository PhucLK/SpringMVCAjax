package com.model;

import java.util.Comparator;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author PhucTV7
 *
 */
@Entity
public class Content {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id;

	private String title;

	private String brief;

	private String content;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date updateDate;

	private int sort;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "member_id")
	private Member member;

	public Content() {
		super();
	}

	/**
	 * @param id
	 * @param title
	 * @param brief
	 * @param content
	 * @param createDate
	 * @param updateDate
	 * @param sort
	 * @param member
	 */
	public Content(int id, String title, String brief, String content, Date createDate, Date updateDate, int sort,
			Member member) {
		super();
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.sort = sort;
		this.member = member;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public String getBrief() {
		return brief;
	}

	/**
	 * @param brief
	 */
	public void setBrief(String brief) {
		this.brief = brief;
	}

	/**
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return
	 */
	public int getSort() {
		return sort;
	}

	/**
	 * @param sort
	 */
	public void setSort(int sort) {
		this.sort = sort;
	}

	/**
	 * @return
	 */
	public Member getMember() {
		return member;
	}

	/**
	 * @param member
	 */
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", title=" + title + ", brief=" + brief + ", content=" + content + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", sort=" + sort + ", member=" + member + "]";
	}

}

class ContentSorted implements Comparator<Content> {

	@Override
	public int compare(Content o1, Content o2) {
		// TODO Auto-generated method stub
		return o1.getSort() - o2.getSort();
	}

}
