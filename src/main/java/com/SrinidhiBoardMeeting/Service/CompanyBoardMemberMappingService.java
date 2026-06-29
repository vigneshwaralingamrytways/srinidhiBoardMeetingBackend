package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanyBoardMemberMappingRepo;
import com.SrinidhiBoardMeeting.model.CompanyBoardMemberMapping;

@Service
public class CompanyBoardMemberMappingService {
	@Autowired
	private CompanyBoardMemberMappingRepo companyBoardMemberMappingRepo;

	public CompanyBoardMemberMapping create(CompanyBoardMemberMapping mapping) {

		return companyBoardMemberMappingRepo.save(mapping);
	}

	public List<CompanyBoardMemberMapping> getAll() {

		return companyBoardMemberMappingRepo.findAll();

	}

	public String delete(Long id) {
		try {

			companyBoardMemberMappingRepo.deleteById(id);
			return "companyBoardMemberMappin Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
