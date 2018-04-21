package com.github.mvp4g.domain.dto.shared.transport.response;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.github.mvp4g.domain.dto.shared.model.Person;

@JsonTypeName("PersonUpdateResponse")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class PersonUpdateResponse
  extends AbstractResponse {

  private Person person;

  public PersonUpdateResponse() {
    super();
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

}
