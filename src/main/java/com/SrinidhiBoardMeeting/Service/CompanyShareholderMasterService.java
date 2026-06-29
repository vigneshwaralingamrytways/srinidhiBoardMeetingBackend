package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanyShareholderMasterRepo;
import com.SrinidhiBoardMeeting.model.CompanyShareholderMaster;

@Service
public class CompanyShareholderMasterService {

	@Autowired
	private CompanyShareholderMasterRepo companyShareholderMasterRepo;

	public CompanyShareholderMaster create(CompanyShareholderMaster shareholder) {

		shareholder.setActive(true);

		return companyShareholderMasterRepo.save(shareholder);
	}

	public List<CompanyShareholderMaster> getAll() {

		return companyShareholderMasterRepo.findByIsActiveTrue();

	}

	public String delete(Long id) {
		try {

			companyShareholderMasterRepo.deleteById(id);
			return "companyShareholderMaster Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
