package tld.domain.project.dto.shared.transport.response;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import tld.domain.project.dto.shared.model.Person;

import java.util.ArrayList;
import java.util.List;

@JsonTypeName("PersonSearchResponse")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class PersonSearchResponse
  extends AbstractResponse {

  private List<Person> listPerson;

  public PersonSearchResponse() {
    super();
    this.listPerson = new ArrayList<>();
  }

  public List<Person> getPersonList() {
    return listPerson;
  }

  public void setPersonList(List<Person> Person) {
    this.listPerson = Person;
  }

}
