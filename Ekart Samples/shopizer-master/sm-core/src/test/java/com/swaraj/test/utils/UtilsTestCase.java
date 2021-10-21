package com.swaraj.test.utils;



import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swaraj.core.business.services.reference.country.CountryService;
import com.swaraj.core.business.services.reference.currency.CurrencyService;
import com.swaraj.core.business.utils.CacheUtils;
import com.swaraj.core.model.common.Address;
import com.swaraj.core.model.reference.currency.Currency;
import com.swaraj.core.modules.utils.Encryption;
import com.swaraj.core.modules.utils.GeoLocation;
import com.swaraj.test.configuration.ConfigurationTest;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ConfigurationTest.class})
@Ignore
public class UtilsTestCase  {
	
	
	@Inject
	private CountryService countryService;
	
	@Inject
	private CurrencyService currencyService;
	
	@Inject
	private Encryption encryption;
	
	@Inject
	private CacheUtils cache;
	
	@Inject
	private GeoLocation geoLoaction;
	

	
	//@Test
	@Ignore
	public void testCache() throws Exception {
		

		
		@SuppressWarnings("rawtypes")
		List countries = countryService.list();

		//CacheUtils cache = CacheUtils.getInstance();
		cache.putInCache(countries, "COUNTRIES");
		
		@SuppressWarnings("rawtypes")
		List objects = (List) cache.getFromCache("COUNTRIES");
		
		Assert.assertNotNull(objects);
		
	}
	
	//@Test
	@Ignore
	public void testCurrency() throws Exception {
		
		Currency currency = currencyService.getByCode("BGN");
		
		java.util.Currency c = currency.getCurrency();
		
		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
		numberFormat.setCurrency(c);
		
		System.out.println("Done");
		
	}
	
	@Test
	public void testGeoLocation() throws Exception {
		
		Address address = geoLoaction.getAddress("96.21.132.0");
		if(address!=null) {
			System.out.println(address.getCountry());
		}
		
	}
	

}
