package com.poc.gcp.api.orderservice.entities;

public class UserInformation { private String firstname; private String lastname;
  private String mobilenumber; private Integer pincode; private ADDRESS
  aDDRESS;
  
  public String getFirstname() { return firstname; }
  
  public void setFirstname(String firstname) { this.firstname = firstname; }
  
  public String getLastname() { return lastname; }
  
  public void setLastname(String lastname) { this.lastname = lastname; }
  
  public String getMobilenumber() { return mobilenumber; }
  
  public void setMobilenumber(String mobilenumber) { this.mobilenumber =
  mobilenumber; }
  
  public Integer getPincode() { return pincode; }
  
  public void setPincode(Integer pincode) { this.pincode = pincode; }
  
  public ADDRESS getADDRESS() { return aDDRESS; }
  
  public void setADDRESS(ADDRESS aDDRESS) { this.aDDRESS = aDDRESS; }
  
  @Override public String toString() { return "UserInformation [firstname=" +
  firstname + ", lastname=" + lastname + ", mobilenumber=" + mobilenumber +
  ", pincode=" + pincode + ", aDDRESS=" + aDDRESS + "]"; }
  
  }
 