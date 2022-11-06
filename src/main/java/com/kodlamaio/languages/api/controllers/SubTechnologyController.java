package com.kodlamaio.languages.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.languages.business.abstracts.SubTechnologyService;
import com.kodlamaio.languages.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.DeleteSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.kodlamaio.languages.business.response.subtechnology.GetAllSubTechnologyResponse;
import com.kodlamaio.languages.business.response.subtechnology.GetByIdSubTechnologyResponse;

@RestController
@RequestMapping("/api/subtechnologies")
public class SubTechnologyController {
	private SubTechnologyService subTechnologyService;

	public SubTechnologyController(SubTechnologyService subTechnologyService) {

		this.subTechnologyService = subTechnologyService;
	}

	@PostMapping("/add")
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@PostMapping("/delete")
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		this.subTechnologyService.delete(deleteSubTechnologyRequest);
	}

	@PostMapping("/update")
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}

	@GetMapping("/getall")
	public List<GetAllSubTechnologyResponse> getAll() {
		return this.subTechnologyService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdSubTechnologyResponse getById(int id) {
		return this.subTechnologyService.getById(id);
	}
}
