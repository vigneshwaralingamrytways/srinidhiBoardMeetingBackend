package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanyMasterRepo;
import com.SrinidhiBoardMeeting.model.companyMaster;

@Service
public class CompanyMasterService {

	@Autowired
	private CompanyMasterRepo companyMasterRepo;

	public List<companyMaster> getAll() {
		return companyMasterRepo.findByIsActiveTrue();

	}

	public companyMaster getById(Long id) {
		return companyMasterRepo.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
	}

	public companyMaster create(companyMaster company) {
		return companyMasterRepo.save(company);
	}

	public companyMaster update(Long id, companyMaster company) {

		companyMaster old = getById(id);

		old.setCompanyName(company.getCompanyName());
		old.setAvatar(company.getAvatar());
		old.setContactNumber(company.getContactNumber());
		old.setState(company.getState());
		old.setPinCode(company.getPinCode());
		old.setCountry(company.getCountry());
		old.setCompanySecretaryName(company.getCompanySecretaryName());
		old.setSecretaryContactNo(company.getSecretaryContactNo());
		old.setSecretaryEmail(company.getSecretaryEmail());
		old.setRegisteredAddress(company.getRegisteredAddress());
		old.setCinNo(company.getCinNo());
		old.setGstNo(company.getGstNo());
		old.setPanNo(company.getPanNo());
		old.setTanNo(company.getTanNo());
		old.setStateOfRegistration(company.getStateOfRegistration());
		old.setEntityType(company.getEntityType());
		old.setTaxRegime(company.getTaxRegime());

		return companyMasterRepo.save(old);
	}

	public String delete(Long id) {

		try {
			companyMasterRepo.deleteById(id);

			return "Company Master Is Deleetd ,Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
