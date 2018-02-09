package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.service.PersonServiceAsync;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.PersonSearch;

public class ClientContext {

  {
    this.personSearch = new PersonSearch();
  }

  private static ClientContext      instance;
  /* searchs */
  private        PersonSearch       personSearch;
  /* Service */
  private        PersonServiceAsync personService;
 
  public ClientContext() {
  }

  public static ClientContext get() {
    if (instance == null) {
      instance = new ClientContext();
      instance.personService = GWT.create(PersonService.class);
    }
    return instance;
  }

  public PersonSearch getPersonSearch() {
    return personSearch;
  }

  public void setPersonSearch(PersonSearch personSearch) {
    this.personSearch = personSearch;
  }

  public PersonServiceAsync getPersonService() {
    return personService;
  }
}
