package com.github.mvp4g2.application.gxtmvp4g2application.client.service;

import com.github.mvp4g2.application.gxtmvp4g2application.client.service.dto.ExceptionInfoService;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.dto.PersonService;
import com.google.gwt.core.client.GWT;
import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Resource;
import org.fusesource.restygwt.client.RestServiceProxy;

public class Services {

  /* instance of the factory */
  private static Services services;
  private        String   path;

  /* Services */
  private ExceptionInfoService exceptionInfoService;
  private PersonService        PersonService;

  private Services() {
    GWT.debugger();
    // set standard date format!
    Defaults.setDateFormat(null);
    // initialize default variable
    String moduleName = GWT.getModuleName();
    GWT.log("getHostPageBaseURL >>" + GWT.getHostPageBaseURL() + "<<");
    GWT.log("getModuleBaseForStaticFiles >>" + GWT.getModuleBaseForStaticFiles() + "<<");
    GWT.log("getModuleBaseURL >>" + GWT.getModuleBaseURL() + "<<");
    path = GWT.getHostPageBaseURL();
    path = path.substring(0,
                          path.lastIndexOf("/"));
    GWT.log("path: >>" + path + "<<");
  }

  public static Services get() {
    if (services == null) {
      services = new Services();
    }
    return services;
  }

  public PersonService getPersonService() {
    if (PersonService == null) {
      PersonService = GWT.create(PersonService.class);
      ((RestServiceProxy) PersonService).setResource(getResource("Person"));
    }
    return PersonService;
  }

  private Resource getResource(String resource) {
    // Resource-Path aufbauen
    StringBuilder resourcePath = new StringBuilder();
    resourcePath.append(path + "/gxt-mvp4g2-server")
                .append("/" + resource);
    GWT.log("current resource path >>" + resourcePath.toString() + "<<");
    return new Resource(resourcePath.toString());
  }

  public ExceptionInfoService getExceptionInfoService() {
    if (exceptionInfoService == null) {
      exceptionInfoService = GWT.create(ExceptionInfoService.class);
      ((RestServiceProxy) exceptionInfoService).setResource(getResource("ExceptionInfo"));
    }
    return exceptionInfoService;
  }
}
