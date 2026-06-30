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
	public List<CompanyShareholderMaster> getActiveByCompanyId(Long companyId) {
        return companyShareholderMasterRepo.findByCompanyIdAndIsActiveTrue(companyId);
    }
	public CompanyShareholderMaster update(Long id, CompanyShareholderMaster shareholder) {

		CompanyShareholderMaster old = companyShareholderMasterRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Shareholder not found : " + id));

		old.setCompanyId(shareholder.getCompanyId());
		old.setShareHolderName(shareholder.getShareHolderName());
		old.setNoOfShares(shareholder.getNoOfShares());
		old.setShareHolderType(shareholder.getShareHolderType());
		old.setDateOfIssueShares(shareholder.getDateOfIssueShares());
		old.setActive(shareholder.isActive());

		return companyShareholderMasterRepo.save(old);
	}
}
