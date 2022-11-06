package com.kodlamaio.languages.business.requests.subtechnology;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSubTechnologyRequest {
	private int subtechnologyId;

	private String subtechnologyName;
	
	
	private int languageId;
}
