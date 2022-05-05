package com.poc.gcp.api.orderservice.entities;



public class ADDRESS {
	private String landmark;
	private Integer pincode;
	private String state;
	private String dist;

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	@Override
	public String toString() {
		return "ADDRESS [landmark=" + landmark + ", pincode=" + pincode + ", state=" + state + ", dist=" + dist + "]";
	}

}