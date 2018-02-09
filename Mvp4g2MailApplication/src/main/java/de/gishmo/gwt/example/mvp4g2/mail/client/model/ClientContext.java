package de.gishmo.gwt.example.mvp4g2.mail.client.model;

public class ClientContext {
//
//  {
//    this.personSearch = new PersonSearch();
//  }
//
  private static ClientContext      instance;
//  /* searchs */
//  private        PersonSearch       personSearch;
//  /* Service */
//  private        PersonServiceAsync personService;

  private ClientContext() {
  }

  public static ClientContext get() {
    if (instance == null) {
      instance = new ClientContext();
//      instance.personService = GWT.create(PersonService.class);
    }
    return instance;
  }
//
//  public PersonSearch getPersonSearch() {
//    return personSearch;
//  }
//
//  public void setPersonSearch(PersonSearch personSearch) {
//    this.personSearch = personSearch;
//  }
//
//  public PersonServiceAsync getPersonService() {
//    return personService;
//  }
}
