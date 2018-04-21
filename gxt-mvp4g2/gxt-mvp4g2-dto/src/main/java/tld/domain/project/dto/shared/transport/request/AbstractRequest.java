package tld.domain.project.dto.shared.transport.request;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import tld.domain.project.dto.shared.AbstractDto;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
public abstract class AbstractRequest
  extends AbstractDto {

  public AbstractRequest() {
    super();
  }

}
