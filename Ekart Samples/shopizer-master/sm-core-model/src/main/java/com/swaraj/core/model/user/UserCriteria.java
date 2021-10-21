package com.swaraj.core.model.user;

import com.swaraj.core.model.common.Criteria;

public class UserCriteria extends Criteria {
	
	private String adminEmail;
	private String adminName;
	private boolean active = true;
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
