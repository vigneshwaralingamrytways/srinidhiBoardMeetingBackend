package com.SrinidhiBoardMeeting.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SrinidhiBoardMeeting.Repo.BoardMemberRepo;
import com.SrinidhiBoardMeeting.model.BoardMember;

@Service
public class BoardMemberService {

	@Autowired
	private BoardMemberRepo boardMemberRepo;

	public BoardMember create(BoardMember boardMember) {

		boardMember.setActive(true);

		return boardMemberRepo.save(boardMember);
	}

	public List<BoardMember> getAll() {

		return boardMemberRepo.findByIsActiveTrue();

	}

	public String delete(Long id) {
		try {

			boardMemberRepo.deleteById(id);
			return "BoardMember Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
