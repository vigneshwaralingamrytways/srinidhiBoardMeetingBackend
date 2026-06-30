package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanyDirectorsRepo;
import com.SrinidhiBoardMeeting.model.CompanyDirectors;

@Service
public class CompanyDirectorsService {
	@Autowired
	private CompanyDirectorsRepo companyDirectorsRepo;

	public List<CompanyDirectors> getAll() {

		return companyDirectorsRepo.findByIsActiveTrue();

	}

	public CompanyDirectors create(CompanyDirectors director) {

		director.setActive(true);

		return companyDirectorsRepo.save(director);
	}

	public String delete(Long id) {

		try {

			companyDirectorsRepo.deleteById(id);
			return "Company Director Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public List<CompanyDirectors> getActiveByCompanyId(Long companyId) {
		return companyDirectorsRepo.findByCompanyIdAndIsActiveTrue(companyId);
	}

	public CompanyDirectors update(Long id, CompanyDirectors director) {

		CompanyDirectors old = companyDirectorsRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Director not found : " + id));

		old.setCompanyId(director.getCompanyId());
		old.setBoardMemberId(director.getBoardMemberId());

		old.setCompanyDirectorName(director.getCompanyDirectorName());
		old.setDin(director.getDin());
		old.setPosition(director.getPosition());

		old.setDateOfJoining(director.getDateOfJoining());

		old.setEmailId(director.getEmailId());
		old.setContactNo(director.getContactNo());

		old.setLeavingDate(director.getLeavingDate());
		old.setLeavingReason(director.getLeavingReason());

		old.setActive(director.isActive());

		return companyDirectorsRepo.save(old);
	}

}
