package com.swaraj.core.business.services.reference.currency;

import com.swaraj.core.business.services.common.generic.SalesManagerEntityService;
import com.swaraj.core.model.reference.currency.Currency;

public interface CurrencyService extends SalesManagerEntityService<Long, Currency> {

	Currency getByCode(String code);

}
