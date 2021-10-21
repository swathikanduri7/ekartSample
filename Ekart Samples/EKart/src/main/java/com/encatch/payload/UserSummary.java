package com.encatch.payload;

public class UserSummary {
    private Long id;
    private String mobileNumber;
    private String name;

    public UserSummary(Long id, String mobileNumber, String name) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  

    public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
