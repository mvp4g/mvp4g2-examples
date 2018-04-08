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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.exception.PersonNotFoundException;

import java.util.List;

@RemoteServiceRelativePath("person")
public interface PersonService
  extends RemoteService {

  Person get(long id)
    throws PersonNotFoundException;

  List<Person> getAll();

  List<Person> get(PersonSearch search);

  void insert(Person person)
    throws PersonException;

  void update(Person person)
    throws PersonException;

}
