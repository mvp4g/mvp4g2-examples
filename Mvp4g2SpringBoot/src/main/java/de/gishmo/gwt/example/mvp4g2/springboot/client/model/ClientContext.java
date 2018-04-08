/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

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
