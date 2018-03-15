package de.gishmo.gwt.example.mvp4g2.springboot.client.model;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.springboot.client.service.PersonService;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

/**
 * Something like a client side session context ...
 * <p>
 * We use this calss to instantiate the service and distribute it to all the presenter/handler.
 */
public class ClientContext {

  private static ClientContext instance;
  /* searchs */
  private        PersonSearch  personSearch;
  /* Service */
  private        PersonService personService;

  {
    this.personSearch = new PersonSearch();
  }

  public ClientContext() {
    this.personService = GWT.create(PersonService.class);
    String pageBaseUrl = GWT.getHostPageBaseURL();
    ((RestServiceProxy) this.personService).setResource(new Resource(pageBaseUrl + "/services/person"));
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

  public PersonService getPersonService() {
    return personService;
  }
}
