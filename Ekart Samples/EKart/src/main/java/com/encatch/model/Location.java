package com.encatch.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "locations", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "locationname"
        }),
        @UniqueConstraint(columnNames = {
                "postalcode"
            })
})
public class Location {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 40)
    private String locationname;
    
    @NotBlank
    @Size(max = 40)
    private String postalcode;
    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "location_categories",
            joinColumns = @JoinColumn(name = "location_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

	public Location() {
	}

	public Location(@NotBlank @Size(max = 40) String locationname, @NotBlank @Size(max = 40) String postalcode) {
		super();
		this.locationname = locationname;
		this.postalcode = postalcode;
	}
	
	public Location(@NotBlank @Size(max = 40) String locationname, @NotBlank @Size(max = 40) String postalcode,
			Set<Category> categories) {
		super();
		this.locationname = locationname;
		this.postalcode = postalcode;
		this.categories = categories;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}


	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationname() {
		return locationname;
	}

	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	

}
