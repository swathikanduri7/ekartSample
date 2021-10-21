package com.swaraj.shop.model.content.box;

import java.util.List;

import com.swaraj.shop.model.content.common.ContentDescription;

public class ReadableContentBoxFull extends ReadableContentBox {

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
