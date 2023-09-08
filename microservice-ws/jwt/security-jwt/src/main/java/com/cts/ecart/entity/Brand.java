package com.cts.ecart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "brands")
public class Brand {

	@Id
	private int brandId;
	private String brandTitle;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandTitle=" + brandTitle + "]";
	}

}
