package com.github.mvp4g.domain.dto.shared.transport.request;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.mvp4g.domain.dto.shared.AbstractDto;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
public abstract class AbstractRequest
  extends AbstractDto {

  public AbstractRequest() {
    super();
  }

}
