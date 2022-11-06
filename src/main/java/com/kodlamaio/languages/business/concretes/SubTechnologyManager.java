package com.kodlamaio.languages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.languages.business.abstracts.LanguageService;
import com.kodlamaio.languages.business.abstracts.SubTechnologyService;
import com.kodlamaio.languages.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.DeleteSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.kodlamaio.languages.business.response.subtechnology.GetAllSubTechnologyResponse;
import com.kodlamaio.languages.business.response.subtechnology.GetByIdSubTechnologyResponse;
import com.kodlamaio.languages.dataAccess.SubTechnologcyRepository;
import com.kodlamaio.languages.entities.concretes.Language;
import com.kodlamaio.languages.entities.concretes.SubTechnology;

@Service
public class SubTechnologyManager implements SubTechnologyService{
	
	private SubTechnologcyRepository subTechnologcyRepository;
	private LanguageService languageService;
	
	
	public SubTechnologyManager(SubTechnologcyRepository subTechnologcyRepository, LanguageService languageService) {
		super();
		this.subTechnologcyRepository = subTechnologcyRepository;
		this.languageService = languageService;
	}

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		Language language=languageService.getLanguageId(createSubTechnologyRequest.getLanguageId());
		SubTechnology subTechnology=SubTechnology.builder()
				.subtechnologyName(createSubTechnologyRequest.getSubtechnologyName())
				.language(language)
				.build();
		this.subTechnologcyRepository.save(subTechnology);
	}

	@Override
	public void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest) {
		SubTechnology subTechnology=this.subTechnologcyRepository.findById(deleteSubTechnologyRequest.getSubtechnologyId()).get();
		this.subTechnologcyRepository.delete(subTechnology);
		
	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		Language language=languageService.getLanguageId(updateSubTechnologyRequest.getLanguageId());
		SubTechnology subTechnology=SubTechnology.builder()
				.subtechnologyId(updateSubTechnologyRequest.getLanguageId())
				.subtechnologyName(updateSubTechnologyRequest.getSubtechnologyName())
				.language(language)
				.build();
		this.subTechnologcyRepository.save(subTechnology);		
	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		List<SubTechnology> result=this.subTechnologcyRepository.findAll();
		List<GetAllSubTechnologyResponse> response=result.stream().map(subtechnology ->GetAllSubTechnologyResponse.builder()
				.subtechnologyId(subtechnology.getSubtechnologyId())
				.subtechnologyName(subtechnology.getSubtechnologyName())
				.build()).collect(Collectors.toList());
		return response;
	}

	@Override
	public GetByIdSubTechnologyResponse getById(int id) {
		SubTechnology result=this.subTechnologcyRepository.findById(id).get();
		GetByIdSubTechnologyResponse response=GetByIdSubTechnologyResponse.builder().
				subtechnologyId(result.getSubtechnologyId())
				.subtechnologyName(result.getSubtechnologyName())
				.languageId(result.getLanguage().getLanguageId())
				.build();
		return response;
	}

}
