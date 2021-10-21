package com.swaraj.core.modules.integration.shipping.model;

import java.util.List;

import com.swaraj.core.business.exception.ServiceException;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.shipping.PackageDetails;
import com.swaraj.core.model.shipping.ShippingProduct;

public interface Packaging {
	
	public List<PackageDetails> getBoxPackagesDetails(
			List<ShippingProduct> products, MerchantStore store) throws ServiceException;
	
	public List<PackageDetails> getItemPackagesDetails(
			List<ShippingProduct> products, MerchantStore store) throws ServiceException;

}
