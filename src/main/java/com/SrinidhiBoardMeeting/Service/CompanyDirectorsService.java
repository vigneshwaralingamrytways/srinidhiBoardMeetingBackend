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

}
