package com.fis.entity;

public class TourPackageDto {

	private String packageId;

	private String sourcePlace;

	private float basicFare;

	private String destinationPlace;

	public TourPackageDto() {
		super();
	}

	public TourPackageDto(String packageId, String sourcePlace, float basicFare, String destinationPlace) {
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
