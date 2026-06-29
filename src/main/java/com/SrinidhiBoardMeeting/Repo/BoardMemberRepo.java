package com.SrinidhiBoardMeeting.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.SrinidhiBoardMeeting.model.BoardMember;

@Repository
public interface  BoardMemberRepo
		extends JpaRepository<BoardMember, Long>, JpaSpecificationExecutor<BoardMember> {

	List<BoardMember> findByIsActiveTrue();

}
