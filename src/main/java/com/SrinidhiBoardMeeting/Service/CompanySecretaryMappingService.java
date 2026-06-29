package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanySecretaryMappingRepo;
import com.SrinidhiBoardMeeting.model.CompanyBoardMemberMapping;
import com.SrinidhiBoardMeeting.model.CompanySecretaryMapping;

@Service
public class CompanySecretaryMappingService {

	@Autowired
	private CompanySecretaryMappingRepo companySecretaryMappingRepo;

	public CompanySecretaryMapping create(CompanySecretaryMapping mapping) {
		return companySecretaryMappingRepo.save(mapping);
	}
	public List<CompanySecretaryMapping> getAll() {

		return companySecretaryMappingRepo.findAll();

	}

	public String delete(Long id) {
		try {

			companySecretaryMappingRepo.deleteById(id);
			return "CompanySecretaryMapping Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
