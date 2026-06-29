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

import com.SrinidhiBoardMeeting.Service.BoardMemberKycDocumentsService;
import com.SrinidhiBoardMeeting.model.BoardMemberKycDocuments;

@RestController
@RequestMapping("/BoardMemberKycDocuments")
public class BoardMemberKycDocumentsController {
	@Autowired
	private BoardMemberKycDocumentsService boardMemberKycDocumentsService;
//tests
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody BoardMemberKycDocuments document) {

		return new ResponseEntity<>(boardMemberKycDocumentsService.create(document), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<BoardMemberKycDocuments>> getAll() {

		return new ResponseEntity<>(boardMemberKycDocumentsService.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		return new ResponseEntity<>(boardMemberKycDocumentsService.delete(id), HttpStatus.OK);
	}

}
