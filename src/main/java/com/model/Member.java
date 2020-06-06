package com.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.exception.DataException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.util.Validator;

/**
 * @author PhucTV7
 *
 */
@Entity
public class Member {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(nullable = false,unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	
	private String phone;
	
	@Column(nullable = false,unique = true)
	private String email;
	
	private String description;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd' 'HH:mm")
	@Temporal(TemporalType.DATE)
	private Date updateTime;
	
	@JsonIgnore
	@OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	private List<Content> contents;

	/**
	 * 
	 */
	public Member() {
		super();
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param phone
	 * @param email
	 * @param description
	 * @param createDate
	 * @param updateTime
	 * @param contents
	 */
	public Member(int id, String firstName, String lastName, String userName, String password, String phone,
			String email, String description, Date createDate, Date updateTime, List<Content> contents) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.description = description;
		this.createDate = createDate;
		this.updateTime = updateTime;
		this.contents = contents;
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
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 * @throws DataException 
	 */
	public void setPhone(String phone) throws DataException {
		if(Validator.isPhoneNumber(phone)) {
			this.phone = phone;
		}else throw new DataException("Phone Number not valid!");
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 * @throws DataException 
	 */
	public void setEmail(String email) throws DataException {
		
		if(Validator.isEmail(email)) {
			this.email = email;
		}else throw new DataException("Email not valid!");
		
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return
	 */
	public List<Content> getContents() {
		return contents;
	}

	/**
	 * @param contents
	 */
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", phone=" + phone + ", Email=" + email + ", Description=" + description
				+ ", createDate=" + createDate + ", updateTime=" + updateTime ;//+ ", contents=" + contents + "]"
	}
	
	

}
