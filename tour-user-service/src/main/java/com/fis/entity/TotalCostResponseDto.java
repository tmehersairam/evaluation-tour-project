package com.fis.entity;

public class TotalCostResponseDto {

	private String source;
	private String destination;
	private double totalCost;

	public TotalCostResponseDto() {
		super();
	}

	public TotalCostResponseDto(String source, String destination, double totalCost) {
		super();
		this.source = source;
		this.destination = destination;
		this.totalCost = totalCost;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalPackCost) {
		this.totalCost = totalPackCost;
	}

}
