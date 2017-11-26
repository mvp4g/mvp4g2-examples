package de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

public class PersonSearch
  implements IsSerializable {

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
