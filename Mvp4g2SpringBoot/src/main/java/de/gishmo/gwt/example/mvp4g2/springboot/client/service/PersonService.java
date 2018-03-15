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
