package com.SrinidhiBoardMeeting.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.CompanySecretaryMapping;
@Repository
public interface CompanySecretaryMappingRepo
		extends JpaRepository<CompanySecretaryMapping, Long>, JpaSpecificationExecutor<CompanySecretaryMapping> {

}
