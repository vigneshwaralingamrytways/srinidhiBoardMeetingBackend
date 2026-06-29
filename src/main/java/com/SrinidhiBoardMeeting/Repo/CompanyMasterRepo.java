package com.SrinidhiBoardMeeting.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.companyMaster;

@Repository
public interface CompanyMasterRepo extends JpaRepository<companyMaster, Long>, JpaSpecificationExecutor<companyMaster> {

	List<companyMaster> findByIsActiveTrue();

}