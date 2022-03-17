package alf.api.web.controllers;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import alf.api.web.models.CompanyInfo;
import alf.api.web.models.Language;
import alf.api.web.payload.response.MessageResponse;
import alf.api.web.repository.CompanyInfoRepository;
import alf.api.web.repository.LanguageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/prepare")
public class PrepareController {

	static final Logger logger = LoggerFactory.getLogger(PrepareController.class);

	@Autowired
	CompanyInfoRepository companyInfoRepository;

	@Autowired
	LanguageRepository languageRepository;

	@GetMapping("/company")
	public ResponseEntity<CompanyInfo> getCompanyInfo() {
		final Optional<CompanyInfo> companyInfo = companyInfoRepository.findById(1L);
		CompanyInfo oCompanyInfo = null;
		if (companyInfo.isPresent())
			oCompanyInfo = companyInfo.get();
		return ResponseEntity.ok(oCompanyInfo);
	}

	@PostMapping("/company")
	public ResponseEntity<?> setCompanyInfo(@Valid @RequestBody final CompanyInfo companyInfo) {
		if (null == companyInfo)
			return ResponseEntity.badRequest().body(new MessageResponse(""));

		CompanyInfo oCompanyInfo = null;
		try {

			oCompanyInfo = companyInfoRepository.save(companyInfo);
		} catch (final Exception ex) {

			logger.debug("    ERROR  : " + ex.getMessage());

			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "CompanyInfo does not create "));
		}

		return ResponseEntity.ok(new MessageResponse(200, "CompanyInfo saved successfully  ", oCompanyInfo));
	}

	@GetMapping("/languages")
	public ResponseEntity<?> getLanguages() {
		List<Language> languages = languageRepository.findAll();
		return ResponseEntity.ok(languages);
	}

	@PostMapping("/language")
	public ResponseEntity<?> saveLanguage(@Valid @RequestBody final Language language) {
		if (null == language)
			return ResponseEntity.badRequest().body(new MessageResponse(""));

		Language oLanguage = null;
		try {

			oLanguage = languageRepository.save(language);
		} catch (final Exception ex) {
			logger.debug("    ERROR  : " + ex.getMessage());

			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Language does not create "));
		}

		return ResponseEntity.ok(new MessageResponse(200, "Language saved successfully  ", oLanguage));
	}
	/*
	 * @GetMapping("/all") public String allAccess() { return "Public Content."; }
	 * 
	 * @GetMapping("/user")
	 * 
	 * @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	 * public String userAccess() { return "User Content."; }
	 * 
	 * @GetMapping("/mod")
	 * 
	 * @PreAuthorize("hasRole('MODERATOR')") public String moderatorAccess() {
	 * return "Moderator Board."; }
	 * 
	 * @GetMapping("/admin")
	 * 
	 * @PreAuthorize("hasRole('ADMIN')") public String adminAccess() { return
	 * "Admin Board."; }
	 */
}
