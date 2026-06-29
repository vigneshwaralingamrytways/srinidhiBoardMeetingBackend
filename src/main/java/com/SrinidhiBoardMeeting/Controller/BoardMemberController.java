package com.SrinidhiBoardMeeting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SrinidhiBoardMeeting.Service.BoardMemberService;
import com.SrinidhiBoardMeeting.model.BoardMember;

@RestController
@RequestMapping("/boardMember")
public class BoardMemberController {
	@Autowired
	private BoardMemberService service;

	@PostMapping("/create")
	public ResponseEntity<BoardMember> create(@RequestBody BoardMember boardMember) {
		return new ResponseEntity<>(service.create(boardMember), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BoardMember>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
