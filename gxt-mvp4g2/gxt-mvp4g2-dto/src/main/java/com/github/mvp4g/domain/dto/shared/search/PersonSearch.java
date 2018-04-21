package com.github.mvp4g.domain.dto.shared.search;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.github.mvp4g.domain.dto.shared.AbstractDto;

import java.io.Serializable;

@SuppressWarnings("serial")
@JsonTypeName("PersonSearch")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class PersonSearch
  extends AbstractDto
  implements Serializable {

  private String name;
  private String city;

  public PersonSearch() {
    super();
  }

  public PersonSearch(String name,
                      String city) {
    super();
    this.name = name;
    this.city = city;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
