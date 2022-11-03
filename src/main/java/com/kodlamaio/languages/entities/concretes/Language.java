package com.kodlamaio.languages.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="languages")
@Builder
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="language_id")
	private int languageId;
	
	@Column(name="language_name")
	private String languageName;
}
