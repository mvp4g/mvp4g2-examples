package com.github.mvp4g2.application.gxtmvp4g2application.client.service.dto;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.github.mvp4g.domain.dto.shared.transport.ExceptionInfo;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

public interface ExceptionInfoService
  extends RestService {

  @POST
  @Path("/exceptionInfo/log")
  void log(ExceptionInfo pExceptionInfo,
           MethodCallback<Void> methodCallback);

}
