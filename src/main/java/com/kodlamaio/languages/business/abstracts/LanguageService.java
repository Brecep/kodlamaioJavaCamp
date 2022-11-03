package com.kodlamaio.languages.business.abstracts;

import java.util.List;

import com.kodlamaio.languages.business.requests.language.CreateLanguageRequest;
import com.kodlamaio.languages.business.requests.language.DeleteLanguageRequest;
import com.kodlamaio.languages.business.requests.language.UpdateLanguageRequest;
import com.kodlamaio.languages.business.response.GetAllLanguageResponse;
import com.kodlamaio.languages.entities.concretes.Language;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;

	void delete(DeleteLanguageRequest deleteLanguageRequest);

	void update(UpdateLanguageRequest updateLanguageRequest);

	List<GetAllLanguageResponse> getAll();

	Language getById(int id);

}
