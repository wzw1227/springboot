package com.wzw.springboot.entity.Admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

public class UsersEntity {
	private Integer user_id;// 用户ID
	private String user_name;// 用户名
	@JsonIgnore
	private String password;// 密码
	private String true_name;// 真实姓名
	private String gender;// 性别
	private String age;// 年龄
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale ="zh",timezone = "GMT+8")
	private Date birthday;//出生年月
	private String department;// 部门
	private String department_code;// 部门代码
	private String contact_title;// 职务
	private String phone;// 手机
	private String mailbox;// 邮箱
	private String family_address;// 家庭住址
	private String home_telephone;// 家庭电话
	private String qq_num;// QQ号码
	private String msn_mum;// MSN号码
	private String id_number;// 身份证编号

	private Date logintime;// 登录时间

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrue_name() {
		return true_name;
	}

	public void setTrue_name(String true_name) {
		this.true_name = true_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment_code() {
		return department_code;
	}

	public void setDepartment_code(String department_code) {
		this.department_code = department_code;
	}

	public String getContact_title() {
		return contact_title;
	}

	public void setContact_title(String contact_title) {
		this.contact_title = contact_title;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMailbox() {
		return mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public String getFamily_address() {
		return family_address;
	}

	public void setFamily_address(String family_address) {
		this.family_address = family_address;
	}

	public String getHome_telephone() {
		return home_telephone;
	}

	public void setHome_telephone(String home_telephone) {
		this.home_telephone = home_telephone;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}

	public String getMsn_mum() {
		return msn_mum;
	}

	public void setMsn_mum(String msn_mum) {
		this.msn_mum = msn_mum;
	}

	public String getId_number() {
		return id_number;
	}

	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	public Date getLogintime() {
		return logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
}
