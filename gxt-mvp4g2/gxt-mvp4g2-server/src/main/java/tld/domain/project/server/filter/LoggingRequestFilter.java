package tld.domain.project.server.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

public class LoggingRequestFilter
  implements ContainerRequestFilter {

  @Override
  public void filter(ContainerRequestContext containerRequestContext)
    throws IOException {
    String method = containerRequestContext.getMethod();

    System.out
      .println("=====================================================================================================================");
    System.out.println("DomainService: Requesting " + method + " for path " + containerRequestContext.getUriInfo()
                                                                                                     .getPath());
    System.out
      .println("=====================================================================================================================");

  }
}
