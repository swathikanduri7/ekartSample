package com.encatch.payload;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.*;

import com.encatch.model.Role;

/**
 * "emailId": "raj@gmail.com",
  "password": "Amma@5018",
  "name": "Swathik",
  "phoneNumber": "9999999999",
  "address": "SR NAGAR,Hyd",
  "registerType": "seller"

 */

public class SignUpRequest {
	
	
    @NotBlank
    @Size(min = 4, max = 40)
    private String name;

    @NotBlank
    @Size(min = 3, max = 15)
    private String phoneNumber;

    @NotBlank
    @Size(max = 40)
    @Email
    private String emailId;

    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    
    
    @NotBlank
    @Size(min = 6, max = 50)
    private String address;
    
    @NotBlank
    @Size(min = 6, max = 50)
    private String registerType;
    
    private Set<Role> roles = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  

   
    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegisterType() {
		return registerType;
	}

	public void setRegisterType(String registerType) {
		this.registerType = registerType;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
    
    
}
