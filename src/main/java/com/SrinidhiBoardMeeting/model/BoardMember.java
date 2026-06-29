package com.SrinidhiBoardMeeting.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Data
public class BoardMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long boardMemberId;
	private String boardMemberName;
	private String avatar;// Initials
	private String emailAddress;
	private String contactNumber;
	private String designation;
	private String education;
	private String experience;
	private String userName;
	private String password;
	//sec part
	private LocalDate dateOfBirth;
	private String gender;
	private String nationality;
	private String din;
	private String phone;
	private String emergencyContact;
	private String residentialAddress;
	private String preferredMailingAddress;
	private boolean isActive = true;
}
