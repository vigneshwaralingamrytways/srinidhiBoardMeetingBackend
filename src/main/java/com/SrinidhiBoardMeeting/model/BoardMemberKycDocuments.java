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
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
 
	@Data
	@Entity
	public class BoardMemberKycDocuments extends BaseEntity{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
		@GenericGenerator(name = "native", strategy = "native")
		private Long BoardMemberKycCDocumentsId;
		@Column(name = "boardMemberId")
		private Long boardMemberId;

		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "boardMemberId",nullable = false, insertable = false, updatable = false)
		private BoardMember BoardMember;
		private String documentName;
		private String idType;
		private String iDNumber;
		private LocalDate expiryDate;
		 
		private String fileName;
		private String extention;
		private String fileSize;
		private String remarks;
		private String generatedFileName;	 
		private String filePath;
		private LocalDate uploadedDate;
		@Transient
		private MultipartFile file;
}
