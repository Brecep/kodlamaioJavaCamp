package com.kodlamaio.languages.business.abstracts;

import java.util.List;

import com.kodlamaio.languages.business.requests.subtechnology.CreateSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.DeleteSubTechnologyRequest;
import com.kodlamaio.languages.business.requests.subtechnology.UpdateSubTechnologyRequest;
import com.kodlamaio.languages.business.response.subtechnology.GetAllSubTechnologyResponse;
import com.kodlamaio.languages.business.response.subtechnology.GetByIdSubTechnologyResponse;

public interface SubTechnologyService {
	void add(CreateSubTechnologyRequest createSubTechnologyRequest);

	void delete(DeleteSubTechnologyRequest deleteSubTechnologyRequest);

	void update(UpdateSubTechnologyRequest updateSubTechnologyRequest);

	List<GetAllSubTechnologyResponse> getAll();

	GetByIdSubTechnologyResponse getById(int id);

}
