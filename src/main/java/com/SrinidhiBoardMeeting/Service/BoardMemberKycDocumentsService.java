package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.BoardMemberKycDocumentsRepo;
import com.SrinidhiBoardMeeting.model.BoardMemberKycDocuments;

@Service
public class BoardMemberKycDocumentsService {
	@Autowired
	private BoardMemberKycDocumentsRepo boardMemberKycDocumentsRepo;

	public BoardMemberKycDocuments create(BoardMemberKycDocuments document) {

		return boardMemberKycDocumentsRepo.save(document);
	}

	public List<BoardMemberKycDocuments> getAll() {

		return boardMemberKycDocumentsRepo.findAll();

	}

	public String delete(Long id) {
		try {

			boardMemberKycDocumentsRepo.deleteById(id);
			return "BoardMember KycDocuments Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
