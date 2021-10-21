package com.swaraj.core.business.services.reference.currency;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.swaraj.core.business.repositories.reference.currency.CurrencyRepository;
import com.swaraj.core.business.services.common.generic.SalesManagerEntityServiceImpl;
import com.swaraj.core.model.reference.currency.Currency;

@Service("currencyService")
public class CurrencyServiceImpl extends SalesManagerEntityServiceImpl<Long, Currency>
	implements CurrencyService {
	
	private CurrencyRepository currencyRepository;
	
	@Inject
	public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
		super(currencyRepository);
		this.currencyRepository = currencyRepository;
	}

	@Override
	public Currency getByCode(String code) {
		return currencyRepository.getByCode(code);
	}

}
