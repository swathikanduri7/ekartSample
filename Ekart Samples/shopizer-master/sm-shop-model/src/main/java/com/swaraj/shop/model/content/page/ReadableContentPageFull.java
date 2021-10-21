package com.swaraj.shop.model.content.page;

import java.util.List;

import com.swaraj.shop.model.content.common.ContentDescription;

public class ReadableContentPageFull extends ReadableContentPage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ContentDescription> descriptions;

	public List<ContentDescription> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(List<ContentDescription> descriptions) {
		this.descriptions = descriptions;
	}

}
