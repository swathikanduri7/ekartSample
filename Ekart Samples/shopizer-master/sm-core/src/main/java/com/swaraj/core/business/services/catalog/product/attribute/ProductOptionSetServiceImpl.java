package com.swaraj.core.business.services.catalog.product.attribute;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.business.repositories.catalog.product.attribute.ProductOptionSetRepository;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityServiceImpl;
import com.swaraj.core.model.catalog.product.attribute.ProductOptionSet;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.reference.language.Language;

@Service("productOptionSetService")
public class ProductOptionSetServiceImpl extends
		SalesManagerEntityServiceImpl<Long, ProductOptionSet> implements ProductOptionSetService {

	
	private ProductOptionSetRepository productOptionSetRepository;
	

	@Inject
	public ProductOptionSetServiceImpl(
			ProductOptionSetRepository productOptionSetRepository) {
			super(productOptionSetRepository);
			this.productOptionSetRepository = productOptionSetRepository;
	}


	@Override
	public List<ProductOptionSet> listByStore(MerchantStore store, Language language) throws ServiceException {
		return productOptionSetRepository.findByStore(store.getId(), language.getId());
	}


	@Override
	public ProductOptionSet getById(MerchantStore store, Long optionSetId, Language lang) {
		return productOptionSetRepository.findOne(store.getId(), optionSetId, lang.getId());
	}


	@Override
	public ProductOptionSet getCode(MerchantStore store, String code) {
		return productOptionSetRepository.findByCode(store.getId(), code);
	}


	@Override
	public List<ProductOptionSet> getByProductType(Long productTypeId, MerchantStore store, Language lang) {
		return productOptionSetRepository.findByProductType(productTypeId, store.getId(), lang.getId());
	}



}
