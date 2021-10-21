package com.swaraj.shop.admin.model.web;

import java.util.List;

import com.swaraj.core.model.system.MerchantConfiguration;



public class ConfigListWrapper
{
	private List<MerchantConfiguration> merchantConfigs;

	public List<MerchantConfiguration> getMerchantConfigs()
	{
		return merchantConfigs;
	}

	public void setMerchantConfigs(List<MerchantConfiguration> merchantConfigs)
	{
		this.merchantConfigs = merchantConfigs;
	}

}
