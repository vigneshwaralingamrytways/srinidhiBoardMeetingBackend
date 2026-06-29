package com.SrinidhiBoardMeeting.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.CompanySecretary;

@Repository
public interface CompanySecretaryRepo
		extends JpaRepository<CompanySecretary, Long>, JpaSpecificationExecutor<CompanySecretary> {

	List<CompanySecretary> findByIsActiveTrue();

}
