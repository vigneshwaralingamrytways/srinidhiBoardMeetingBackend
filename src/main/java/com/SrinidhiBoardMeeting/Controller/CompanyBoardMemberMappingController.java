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

import com.SrinidhiBoardMeeting.Service.CompanyBoardMemberMappingService;
import com.SrinidhiBoardMeeting.model.CompanyBoardMemberMapping;

@RestController
@RequestMapping("/companyBoardMemberMapping")
public class CompanyBoardMemberMappingController {
	@Autowired
    private CompanyBoardMemberMappingService service;

    @PostMapping("/create")
    public ResponseEntity<CompanyBoardMemberMapping> create(@RequestBody CompanyBoardMemberMapping mapping) {
        return new ResponseEntity<>(service.create(mapping), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanyBoardMemberMapping>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
