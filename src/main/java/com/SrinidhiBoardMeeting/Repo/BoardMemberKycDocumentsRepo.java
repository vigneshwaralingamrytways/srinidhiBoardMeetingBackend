package com.SrinidhiBoardMeeting.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.BoardMemberKycDocuments;

@Repository
public interface BoardMemberKycDocumentsRepo
		extends JpaRepository<BoardMemberKycDocuments, Long>, JpaSpecificationExecutor<BoardMemberKycDocuments> {

//	List<BoardMemberKycCDocuments> findByIsActiveTrue();

}
