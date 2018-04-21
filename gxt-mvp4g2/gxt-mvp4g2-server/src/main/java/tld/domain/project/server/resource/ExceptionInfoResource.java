package tld.domain.project.server.resource;

import tld.domain.project.dto.shared.transport.ExceptionInfo;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Singleton
@Path("/exceptionInfo")
public class ExceptionInfoResource {

  @POST
  @Path("/log")
  @Consumes("application/json")
  public void save(ExceptionInfo exceptionInfo) {

    System.out.println("=====");
    System.out.println(exceptionInfo.toString());
    System.out.println("=====");

  }
}
