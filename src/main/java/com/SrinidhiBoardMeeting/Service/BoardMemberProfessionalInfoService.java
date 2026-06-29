package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.BoardMemberProfessionalInfoRepo;
import com.SrinidhiBoardMeeting.model.BoardMemberProfessionalInfo;

@Service
public class BoardMemberProfessionalInfoService {
	@Autowired
	private BoardMemberProfessionalInfoRepo boardMemberProfessionalInfoRepo;

	public BoardMemberProfessionalInfo create(BoardMemberProfessionalInfo info) {
		return boardMemberProfessionalInfoRepo.save(info);
	}

	public List<BoardMemberProfessionalInfo> getAll() {

		return boardMemberProfessionalInfoRepo.findAll();

	}

	public String delete(Long id) {
		try {

			boardMemberProfessionalInfoRepo.deleteById(id);
			return "BoardMember KycDocuments Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
