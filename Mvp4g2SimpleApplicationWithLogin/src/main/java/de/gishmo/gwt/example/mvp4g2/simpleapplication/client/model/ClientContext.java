package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;

public class ClientContext {

  private static ClientContext instance;
  /* searchs */
  private        PersonSearch  personSearch;
  /* user logged in? */
  private boolean loggedIn;

  {
    this.personSearch = new PersonSearch();
    this.loggedIn = false;
  }

  public ClientContext() {
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

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
}
