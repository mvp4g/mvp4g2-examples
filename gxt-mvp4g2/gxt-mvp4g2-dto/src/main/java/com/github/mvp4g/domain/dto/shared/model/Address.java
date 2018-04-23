package com.github.mvp4g.domain.dto.shared.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address
    implements Serializable {

  private long adressId;

  private String street;

  private String zip;

  private String city;

  /* for serialization only */
  public Address() {
    super();
  }

  public Address(long adressId,
                 String street,
                 String zip,
                 String city) {
    super();

    this.adressId = adressId;
    this.street = street;
    this.zip = zip;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public long getAdressId() {
    return adressId;
  }

  public void setAdressId(long adressId) {
    this.adressId = adressId;
  }
}
