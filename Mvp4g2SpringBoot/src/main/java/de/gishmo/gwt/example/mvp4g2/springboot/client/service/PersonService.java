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

package de.gishmo.gwt.example.mvp4g2.springboot.client.service;

import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.PersonSearch;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

public interface PersonService
  extends RestService {

  @GET
  @Path("/get")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  void get(@QueryParam("id") String id,
           MethodCallback<Person> methodCallBack);

  @GET
  @Path("/getAll")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  void get(MethodCallback<List<Person>> methodCallBack);

  @POST
  @Path("/search")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  void search(PersonSearch search,
              MethodCallback<List<Person>> methodCallBack);

  @POST
  @Path("/insert")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  void insert(Person person,
              MethodCallback<Void> methodCallBack);

  @POST
  @Path("/update")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  void udpate(Person person,
              MethodCallback<Void> methodCallBack);

}
