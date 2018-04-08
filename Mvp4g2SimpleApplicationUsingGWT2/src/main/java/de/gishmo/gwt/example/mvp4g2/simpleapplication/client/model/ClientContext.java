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
