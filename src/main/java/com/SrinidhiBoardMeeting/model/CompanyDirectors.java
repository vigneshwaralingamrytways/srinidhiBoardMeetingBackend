package com.SrinidhiBoardMeeting.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.SrinidhiBoardMeeting.model.BaseEntity;

import lombok.Data;

@Entity
@Data
public class CompanyDirectors extends BaseEntity  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long companyDirectorsId;

	@Column(name = "company_id")
	private Long companyId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id",nullable=false,  insertable = false, updatable = false)
	private companyMaster companyMaster;
	
	@Column(name = "boardMemberId")
	private Long boardMemberId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "boardMemberId",insertable = false, updatable = false)
	private BoardMember BoardMember;
	private String companyDirectorName; // Store the director Id
	private String din;
	private String position;
	private LocalDate dateOfJoining;
	private String emailId;
	private String contactNo;
	private LocalDate leavingDate;
	private String leavingReason;
	private boolean isActive=true;

}
