package com.SrinidhiBoardMeeting.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.companyDocuments;

@Repository
public interface CompanyDocumentsRepo extends JpaRepository<companyDocuments, Long>, JpaSpecificationExecutor<companyDocuments> {

	List<companyDocuments> findByCompanyId(Long companyId);
	boolean existsByGeneratedFileName(String generatedFileName);
	
	

//	List<companyDocuments> findAllIsActiveTrue();

}
