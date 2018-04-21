package com.github.mvp4g2.application.gxtmvp4g2application.client.model;

import com.github.mvp4g.domain.dto.shared.search.PersonSearch;

public class ClientContext {

  private static ClientContext instance;


  /* searchs */
  private PersonSearch personSearch;

  public ClientContext() {
    this.personSearch = new PersonSearch();
  }


  public static ClientContext get() {
    if (instance == null) {
      instance = new ClientContext();
    }
    return instance;
  }

  public PersonSearch getPersonSearch() {
    return personSearch;
  }

  public void setPersonSearch(PersonSearch personSearch) {
    this.personSearch = personSearch;
  }
}
