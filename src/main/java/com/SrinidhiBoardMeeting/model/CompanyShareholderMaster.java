package com.SrinidhiBoardMeeting.model;

import java.math.BigDecimal;
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

import com.SrinidhiBoardMeeting.model.BaseEntity;

import lombok.Data;

@Entity
@Data
public class CompanyShareholderMaster extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long shareHolderId;
//testdd 
	@Column(name = "company_id")
	private Long companyId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", insertable = false, updatable = false)
	private companyMaster companyMaster;
	private String shareHolderName;
	private BigDecimal noOfShares;
	private String shareHolderType; // How Did They Become Shareholder

	private LocalDate dateOfIssueShares;
	private boolean isActive=true;
}
