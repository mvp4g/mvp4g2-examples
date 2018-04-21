package tld.domain.project.dto.shared.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import tld.domain.project.dto.shared.AbstractDto;

import java.io.Serializable;

@SuppressWarnings("serial")
@JsonTypeName("Address")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class Address
  extends AbstractDto
  implements Serializable {

  private long id;

  private String street;
  private String zip;
  private String city;

  /* for serialization only */
  public Address() {
    super();
  }

  public Address(long id,
                 String street,
                 String zip,
                 String city) {
    super();

    this.id = id;
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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
