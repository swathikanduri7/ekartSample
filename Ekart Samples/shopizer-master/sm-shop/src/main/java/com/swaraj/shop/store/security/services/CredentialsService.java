package com.swaraj.shop.store.security.services;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

public interface CredentialsService {
	
	/**
	 * Password validation with specific rules
	 * @param password
	 * @param repeatPassword
	 * @param store
	 * @param language
	 * @throws CredentialsException
	 */
	void validateCredentials(String password, String repeatPassword, MerchantStore store, Language language) throws CredentialsException;
	
	/**
	 * Generates password based on specific rules
	 * @param store
	 * @param language
	 * @return
	 * @throws CredentialsException
	 */
	String generatePassword(MerchantStore store, Language language) throws CredentialsException;

}
