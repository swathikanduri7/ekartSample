package com.swaraj.core.business.services.shipping;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.swaraj.core.business.repositories.shipping.ShippingOriginRepository;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityServiceImpl;
import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.core.model.shipping.ShippingOrigin;



@Service("shippingOriginService")
public class ShippingOriginServiceImpl extends SalesManagerEntityServiceImpl<Long, ShippingOrigin> implements ShippingOriginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShippingOriginServiceImpl.class);
	
	private ShippingOriginRepository shippingOriginRepository;

	

	@Inject
	public ShippingOriginServiceImpl(ShippingOriginRepository shippingOriginRepository) {
		super(shippingOriginRepository);
		this.shippingOriginRepository = shippingOriginRepository;
	}


	@Override
	public ShippingOrigin getByStore(MerchantStore store) {
		// TODO Auto-generated method stub
		return shippingOriginRepository.findByStore(store.getId());
	}
	

}
