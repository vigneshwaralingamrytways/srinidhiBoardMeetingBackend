package com.SrinidhiBoardMeeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class companyDocuments extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long companyDocumentsId;
	@Column(name = "company_id")
	private Long companyId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id", nullable = false, insertable = false, updatable = false)
	private companyMaster companyMaster;
	private String documentType;

	private String fileName;
	private String extention;
	private String fileSize;
	private String generatedFileName;
	private String remarks;
	private String filePath;
//	private LocalDate uploadedDate;
	@Transient
	@JsonIgnore
	private MultipartFile file;

//	private boolean isActive = true;

}
