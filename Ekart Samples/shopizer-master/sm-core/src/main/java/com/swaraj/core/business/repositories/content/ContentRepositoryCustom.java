package com.swaraj.core.business.repositories.content;

import java.util.List;

import com.swaraj.core.model.content.ContentDescription;
import com.swaraj.core.model.content.ContentType;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;


public interface ContentRepositoryCustom {

	List<ContentDescription> listNameByType(List<ContentType> contentType,
			MerchantStore store, Language language);

	ContentDescription getBySeUrl(MerchantStore store, String seUrl);
	

}
