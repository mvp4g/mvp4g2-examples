package com.github.mvp4g.domain.dto.shared.transport.response;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.mvp4g.domain.dto.shared.AbstractDto;
import com.github.mvp4g.domain.dto.shared.transport.Status;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class AbstractResponse
  extends AbstractDto {

  private Status status;

  public AbstractResponse() {
    super();
    status = new Status();
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
