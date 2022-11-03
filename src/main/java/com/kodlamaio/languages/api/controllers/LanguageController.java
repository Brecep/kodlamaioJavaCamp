package com.kodlamaio.languages.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.languages.business.abstracts.LanguageService;
import com.kodlamaio.languages.business.requests.language.CreateLanguageRequest;
import com.kodlamaio.languages.business.requests.language.DeleteLanguageRequest;
import com.kodlamaio.languages.business.requests.language.UpdateLanguageRequest;
import com.kodlamaio.languages.business.response.GetAllLanguageResponse;
import com.kodlamaio.languages.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@PostMapping("/add")
	private void add(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
		this.languageService.add(createLanguageRequest);
	}

	@PostMapping("/delete")
	private void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}

	@PostMapping("/update")
	private void update(@RequestBody UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest);
	}

	@GetMapping("/getall")
	private List<GetAllLanguageResponse> getAll() {
		return this.languageService.getAll();
	}

	@GetMapping("/getbyid")
	private Language getById(@RequestParam int id) {
		return this.languageService.getById(id);
	}
}
