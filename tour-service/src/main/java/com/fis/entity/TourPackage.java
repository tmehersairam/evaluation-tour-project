package com.fis.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class TourPackage {

	@Id
	@Size(min = 7, max = 7, message = "Package Id should of Size 7")
	@NotEmpty
	private String packageId = UUID.randomUUID().toString().substring(0, 7);
	@NotEmpty(message = "Source place should not be empty")
	private String sourcePlace;

	@Min(value = 1, message = "Basic fare should be greater than 0")
	private float basicFare;

	@NotEmpty(message = "Destination place should not be empty")
	private String destinationPlace;

	public TourPackage() {
		super();
	}

	public TourPackage(String packageId, String sourcePlace, float basicFare, String destinationPlace) {
		super();
		this.packageId = packageId;
		this.sourcePlace = sourcePlace;
		this.basicFare = basicFare;
		this.destinationPlace = destinationPlace;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getSourcePlace() {
		return sourcePlace;
	}

	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}

	public float getBasicFare() {
		return basicFare;
	}

	public void setBasicFare(float basicFare) {
		this.basicFare = basicFare;
	}

	public String getDestinationPlace() {
		return destinationPlace;
	}

	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}

}
