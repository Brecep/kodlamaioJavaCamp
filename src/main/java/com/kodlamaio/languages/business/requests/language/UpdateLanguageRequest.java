package com.kodlamaio.languages.business.requests.language;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateLanguageRequest {
	private int languageId;
	private String languageName;
}
