package com.kodlamaio.languages.business.response.language;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageResponse {
	private int languageId;
	private String languageName;
}
