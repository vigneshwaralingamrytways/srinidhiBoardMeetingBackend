package com.SrinidhiBoardMeeting.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SrinidhiBoardMeeting.Service.CompanyDocumentsService;
import com.SrinidhiBoardMeeting.model.companyDocuments;

@RestController
@RequestMapping("/companyDocuments")
public class CompanyDocumentsController {
	@Autowired
	private CompanyDocumentsService companyDocumentsService;

	@GetMapping("/getAll")
	public List<companyDocuments> getAll() {
		return companyDocumentsService.getAll();
	}

	@GetMapping("getById/{id}")
	public companyDocuments getById(@PathVariable Long id) {

		return companyDocumentsService.getById(id);
	}

	@PostMapping("/create")
	public companyDocuments create(@RequestBody companyDocuments document) throws IOException {

		return companyDocumentsService.create(document);
	}

	@PostMapping("/fileUpload")
	public companyDocuments upload(@RequestParam Long companyId, @RequestParam String documentType,
			@RequestParam MultipartFile file) throws IOException {

		companyDocuments document = new companyDocuments();

		document.setCompanyId(companyId);
		document.setDocumentType(documentType);
		document.setFile(file);

		return companyDocumentsService.create(document);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable Long id) {

		return companyDocumentsService.delete(id);
	}

	@GetMapping("/download/{documentId}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable Long documentId) throws IOException {

		return companyDocumentsService.download(documentId);
	}

	@GetMapping("/getByCompany/{companyId}")
	public List<companyDocuments> getByCompanyId(@PathVariable Long companyId) {
		return companyDocumentsService.getByCompanyId(companyId);
	}

}
