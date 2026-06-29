package com.SrinidhiBoardMeeting.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.CompanyBoardMemberMapping;
@Repository
public interface CompanyBoardMemberMappingRepo
		extends JpaRepository<CompanyBoardMemberMapping, Long>, JpaSpecificationExecutor<CompanyBoardMemberMapping> {

}
