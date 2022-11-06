package com.kodlamaio.languages.business.requests.subtechnology;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteSubTechnologyRequest {
	private int subtechnologyId;
}
