package com.SrinidhiBoardMeeting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class companyMaster extends BaseEntity  {
//	1.Identity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long companyId;

	private String companyName;
	private String avatar;//logo init
	private String contactNumber;
	private String state;
	private String pinCode;
	private String country;
	private String companySecretaryName;
	private String secretaryContactNo;
	private String secretaryEmail;
	@Lob
	private String registeredAddress;
	
	//2.Tax & Registration
	private String cinNo;
	private String gstNo;
	private String panNo;
	private String tanNo;
	private String stateOfRegistration;
	private String entityType;
	private String taxRegime;
	private boolean isActive=true;
	
}
