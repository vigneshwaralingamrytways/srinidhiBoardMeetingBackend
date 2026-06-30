package com.SrinidhiBoardMeeting.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.SrinidhiBoardMeeting.Repo.CompanyDocumentsRepo;
import com.SrinidhiBoardMeeting.model.companyDocuments;

@Service
public class CompanyDocumentsService {
	@Autowired
	private CompanyDocumentsRepo companyDocumentsRepo;

	@Value("${upload.path}")
	private String uploadPath;

	public List<companyDocuments> getAll() {
		return companyDocumentsRepo.findAll();
	}

	public companyDocuments getById(Long id) {
		return companyDocumentsRepo.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
	}

	public List<companyDocuments> getByCompanyId(Long companyId) {
		return companyDocumentsRepo.findByCompanyId(companyId);
	}

	public companyDocuments create(companyDocuments document) throws IOException {

		if (document.getFile() != null) {

			File folder = new File(uploadPath);

			if (!folder.exists()) {
				folder.mkdirs();
			}

			String fileName = System.currentTimeMillis() + "_" + document.getFile().getOriginalFilename();

			String path = uploadPath + File.separator + fileName;

			document.getFile().transferTo(new File(path));
			MultipartFile file = document.getFile();

//			String originalFileName = file.getOriginalFilename();
			String originalFileName = StringUtils.cleanPath(document.getFile().getOriginalFilename());

			String generatedFileName = generateUniqueFileName(originalFileName);
			document.setGeneratedFileName(generatedFileName);

			String extension = "";

			if (originalFileName != null && originalFileName.contains(".")) {
				extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
			}
			document.setExtention(extension);

			long size = file.getSize();

			if (size < 1024) {
				document.setFileSize(size + " Bytes");
			} else if (size < 1024 * 1024) {
				document.setFileSize((size / 1024) + " KB");
			} else {
				document.setFileSize((size / (1024 * 1024)) + " MB");
			}
			document.setFileName(originalFileName);
			document.setFilePath(path);

		}

		return companyDocumentsRepo.save(document);
	}

	private String generateUniqueFileName(String originalFileName) {

		if (originalFileName == null || !originalFileName.contains(".")) {
			throw new IllegalArgumentException("Invalid file name");
		}

		String extension = originalFileName.substring(originalFileName.lastIndexOf('.') + 1);

		String baseName = originalFileName.substring(0, originalFileName.lastIndexOf('.')).replaceAll("\\s+", "_");

		String generatedFileName;
		int attempt = 0;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS");

		do {
			String dateTime = LocalDateTime.now().format(formatter);

			String uuid = UUID.randomUUID().toString().replace("-", "");

			generatedFileName = dateTime + "_" + uuid + "_" + baseName + "." + extension;

			attempt++;

			if (attempt > 5) {
				throw new IllegalStateException("Unable to generate unique file name");
			}

		} while (companyDocumentsRepo.existsByGeneratedFileName(generatedFileName));

		return generatedFileName;
	}

	public ResponseEntity<ByteArrayResource> download(Long documentId) throws IOException {

		companyDocuments document = companyDocumentsRepo.findById(documentId)
				.orElseThrow(() -> new RuntimeException("Document not found"));

		File file = new File(document.getFilePath());

		if (!file.exists()) {
			return ResponseEntity.notFound().build();
		}

		Path path = Paths.get(file.getAbsolutePath());

		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		HttpHeaders headers = new HttpHeaders();

		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + document.getFileName());

		return ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
	}

	public String delete(Long id) {

		try {
			companyDocumentsRepo.deleteById(id);

			return "Company Document Is Deleted, Id : " + id;

		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
