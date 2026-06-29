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

import com.SrinidhiBoardMeeting.Service.CompanyDirectorsService;
import com.SrinidhiBoardMeeting.model.CompanyDirectors;

@RestController
@RequestMapping("/companyDirectors")
public class CompanyDirectorsController {
	@Autowired
	private CompanyDirectorsService service;

	@PostMapping("/create")
	public ResponseEntity<CompanyDirectors> create(@RequestBody CompanyDirectors director) {
		return new ResponseEntity<>(service.create(director), HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<CompanyDirectors>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
