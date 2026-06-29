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

import com.SrinidhiBoardMeeting.Service.CompanySecretaryMappingService;
import com.SrinidhiBoardMeeting.model.CompanySecretaryMapping;

@RestController
@RequestMapping("/CompanySecretary")
public class CompanySecretaryMappingController {
	@Autowired
    private CompanySecretaryMappingService service;

    @PostMapping("/create")
    public ResponseEntity<CompanySecretaryMapping> create(@RequestBody CompanySecretaryMapping mapping) {
        return new ResponseEntity<>(service.create(mapping), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CompanySecretaryMapping>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
