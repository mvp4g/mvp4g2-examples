package com.github.mvp4g2.application.gxtmvp4g2application.client.service.dto;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.domain.dto.shared.search.PersonSearch;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.Options;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * der PersonService als RestyGWT-Service mit JAX-RS-Annotationen
 */
@Path("/Person")
public interface PersonService
    extends RestService {

  @GET
  @Path("/get/{id}")
  void get(@PathParam("id") String id,
           MethodCallback<Person> callback);

  @POST
  @Path("/search")
  void search(PersonSearch search,
              MethodCallback<List<Person>> callback);

  @POST
  @Path("/insert")
  void insert(Person person,
              MethodCallback<Void> callback);

  @POST
  @Path("/update")
  void update(Person person,
              MethodCallback<Void> callback);

}
