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

import com.SrinidhiBoardMeeting.model.BaseEntity;

import lombok.Data;

@Entity
@Data
public class CompanySecretaryMapping extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long companySecretaryMappingId;

	@Column(name = "company_id")
	private Long companyId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private companyMaster companyMaster;

	@Column(name = "companySecretaryId")
	private Long companySecretaryId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "companySecretaryId", nullable = false, insertable = false, updatable = false)
	private CompanySecretary CompanySecretary;

//	private String chiefSecretaryName;//- add chefsecrtert mapping
	private LocalDate createdDate;


}
