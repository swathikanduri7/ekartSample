package com.swaraj.core.business.services.system;



import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.modules.email.Email;
import com.swaraj.core.business.modules.email.EmailConfig;
import com.swaraj.core.model.merchant.MerchantStore;


public interface EmailService {

	void sendHtmlEmail(MerchantStore store, Email email) throws ServiceException, Exception;
	
	EmailConfig getEmailConfiguration(MerchantStore store) throws ServiceException;
	
	void saveEmailConfiguration(EmailConfig emailConfig, MerchantStore store) throws ServiceException;
	
}
