package com.kodlamaio.languages.business.response.language;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllLanguageResponse {
	private int languageId;
	private String languageName;
}
