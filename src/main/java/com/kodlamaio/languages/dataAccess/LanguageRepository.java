package com.kodlamaio.languages.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.languages.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{
	//Language findByName(String name);
}
