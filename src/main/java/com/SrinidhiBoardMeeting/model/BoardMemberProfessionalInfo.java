package com.SrinidhiBoardMeeting.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class BoardMemberProfessionalInfo extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long BoardMemberProfessionalInfoId;

//	@Column(name = "company_id")
//	private Long companyId;
//
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "company_id", insertable = false, updatable = false)
//	private companyMaster companyMaster;
	private String companyName;
	@Column(name = "boardMemberId")
	private Long boardMemberId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "boardMemberId",nullable = false, insertable = false, updatable = false)
	private BoardMember BoardMember;
	private String designation;
	private BigDecimal noOfShares;
	private BigDecimal holdingPercentage;
}
