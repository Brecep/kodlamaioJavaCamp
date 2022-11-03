package com.kodlamaio.languages.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlamaio.languages.business.abstracts.LanguageService;
import com.kodlamaio.languages.business.requests.language.CreateLanguageRequest;
import com.kodlamaio.languages.business.requests.language.DeleteLanguageRequest;
import com.kodlamaio.languages.business.requests.language.UpdateLanguageRequest;
import com.kodlamaio.languages.business.response.GetAllLanguageResponse;
import com.kodlamaio.languages.dataAccess.LanguageRepository;
import com.kodlamaio.languages.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		checkIfExistName(createLanguageRequest.getLanguageName());
		checkIfEmptyNameExists(createLanguageRequest.getLanguageName());
		Language language=Language.builder()
				.languageName(createLanguageRequest.getLanguageName())
			.build();
		
		this.languageRepository.save(language);
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		Language language=this.languageRepository.findById(deleteLanguageRequest.getLanguageId()).get();
		this.languageRepository.delete(language);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		Language language=this.languageRepository.findById(updateLanguageRequest.getLanguageId()).get();
		this.languageRepository.save(language);
		
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> result=this.languageRepository.findAll();
		List<GetAllLanguageResponse> response=result.stream().map(language ->GetAllLanguageResponse.builder()
				.languageId(language.getLanguageId())
				.languageName(language.getLanguageName())
				.build()).collect(Collectors.toList());
				
		return response;
	}

	@Override
	public Language getById(int id) {	
		return this.languageRepository.findById(id).get();
	}
	
	private void checkIfExistName(String name) throws Exception {
		for (Language item : this.languageRepository.findAll()) {
			if(item.getLanguageName().equals(name)) {
				throw new Exception("Ayni isim tekrarlayamaz");
			}
		}
	}
	
	
	private void checkIfEmptyNameExists(String name) throws Exception {
		//Language language=this.languageRepository.findByName(name);
		if(name.isEmpty() || name.isBlank()) {
			throw new Exception("Programlama ismi boş geçilemez");
		}
	}
	
}
