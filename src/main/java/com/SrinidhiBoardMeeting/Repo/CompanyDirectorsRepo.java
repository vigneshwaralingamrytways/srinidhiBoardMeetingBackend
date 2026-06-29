package com.SrinidhiBoardMeeting.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.CompanyDirectors;

@Repository
public interface CompanyDirectorsRepo
		extends JpaRepository<CompanyDirectors, Long>, JpaSpecificationExecutor<CompanyDirectors> {

	List<CompanyDirectors> findByIsActiveTrue();

}