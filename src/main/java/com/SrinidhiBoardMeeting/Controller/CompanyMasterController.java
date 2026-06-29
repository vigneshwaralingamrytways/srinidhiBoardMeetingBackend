package com.SrinidhiBoardMeeting.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SrinidhiBoardMeeting.Service.CompanyMasterService;
import com.SrinidhiBoardMeeting.model.companyMaster;
@RestController
@RequestMapping("/company")
public class CompanyMasterController {
	@Autowired
    private CompanyMasterService service;

    @PostMapping("/create")
    public ResponseEntity<companyMaster> create(@RequestBody companyMaster company) {
        return new ResponseEntity<>(service.create(company), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<companyMaster> update(@PathVariable Long id, @RequestBody companyMaster company) {
        return new ResponseEntity<>(service.update(id, company), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<companyMaster>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}