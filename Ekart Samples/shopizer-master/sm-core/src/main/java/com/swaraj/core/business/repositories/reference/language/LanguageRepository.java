package com.swaraj.core.business.repositories.reference.language;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.reference.language.Language;

public interface LanguageRepository extends JpaRepository <Language, Integer> {
	
	Language findByCode(String code) throws ServiceException;
	


}
