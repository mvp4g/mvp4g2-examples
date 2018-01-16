package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto;

import java.io.Serializable;

public class PersonSearch
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
