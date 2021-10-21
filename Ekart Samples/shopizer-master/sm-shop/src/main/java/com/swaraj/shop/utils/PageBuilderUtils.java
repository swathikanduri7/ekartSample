package com.swaraj.shop.utils;

import com.swaraj.core.model.merchant.MerchantStore;
import com.swaraj.shop.constants.Constants;
import com.swaraj.shop.store.controller.ControllerConstants;

public class PageBuilderUtils {
	
	public static String build404(MerchantStore store) {
		return new StringBuilder().append(ControllerConstants.Tiles.Pages.notFound).append(".").append(store.getStoreTemplate()).toString();
	}
	
	public static String buildHomePage(MerchantStore store) {
		return "redirect:" + Constants.SHOP_URI;
	}

}
