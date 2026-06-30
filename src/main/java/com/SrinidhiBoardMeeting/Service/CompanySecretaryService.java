package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.CompanySecretaryRepo;
import com.SrinidhiBoardMeeting.model.CompanySecretary;

@Service
public class CompanySecretaryService {
	@Autowired
	private CompanySecretaryRepo companySecretaryRepo;

	public CompanySecretary create(CompanySecretary secretary) {

		secretary.setActive(true);

		return companySecretaryRepo.save(secretary);
	}

	public List<CompanySecretary> getAll() {

		return companySecretaryRepo.findByIsActiveTrue();

	}

	public String delete(Long id) {
		try {

			companySecretaryRepo.deleteById(id);
			return "companySecretary Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
 
}
