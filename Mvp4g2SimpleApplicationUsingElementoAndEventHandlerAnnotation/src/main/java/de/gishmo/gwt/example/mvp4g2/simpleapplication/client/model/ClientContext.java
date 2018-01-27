package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;

/**
 * Something like a client side session context ...
 *
 * We use this calss to instantiate the service and distribute it to all the presenter/handler.
 */
public class ClientContext {

  private static ClientContext instance;
  /* searchs */
  private        PersonSearch  personSearch;

  {
    this.personSearch = new PersonSearch();
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
}
