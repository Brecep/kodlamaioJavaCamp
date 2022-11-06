package com.kodlamaio.languages.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sub_technology")
@Builder
public class SubTechnology {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="subtechnology_id")
	private int subtechnologyId;
	
	@Column(name="subtechnology_name")
	private String subtechnologyName;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private Language language;
	
	
}
