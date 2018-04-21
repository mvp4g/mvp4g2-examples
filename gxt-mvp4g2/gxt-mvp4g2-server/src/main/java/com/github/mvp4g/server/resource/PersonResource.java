package com.github.mvp4g.server.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.github.mvp4g.domain.dto.shared.model.Address;
import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.domain.dto.shared.search.PersonSearch;
import com.github.mvp4g.domain.dto.shared.transport.ReturnCode;
import com.github.mvp4g.domain.dto.shared.transport.Status;
import com.github.mvp4g.domain.dto.shared.transport.response.PersonGetResponse;
import com.github.mvp4g.domain.dto.shared.transport.response.PersonInsertResponse;
import com.github.mvp4g.domain.dto.shared.transport.response.PersonSearchResponse;
import com.github.mvp4g.domain.dto.shared.transport.response.PersonUpdateResponse;

@Singleton
@Path("/Person")
public class PersonResource {

  private static Map<Long, Person> dummyDB;

  public PersonResource() {
    init();
  }

  private void init() {
    dummyDB = new HashMap<Long, Person>();
    Address address01 = new Address(1,
                                    "Evergreen Terrace",
                                    "7 42",
                                    "Springfield");
    dummyDB.put(new Long(1),
                new Person(1,
                           "Simpsons",
                           "Homer",
                           address01));
    dummyDB.put(new Long(2),
                new Person(2,
                           "Simpsons",
                           "Marge",
                           address01));
    dummyDB.put(new Long(3),
                new Person(3,
                           "Simpsons",
                           "Bart",
                           address01));
    dummyDB.put(new Long(4),
                new Person(4,
                           "Simpsons",
                           "Maggie",
                           address01));
    dummyDB.put(new Long(5),
                new Person(5,
                           "Simpsons",
                           "Lisa",
                           address01));
    Address address02 = new Address(2,
                                    "Blumenweg Nr. 13",
                                    "88999",
                                    "Entenhausen");
    dummyDB.put(new Long(6),
                new Person(6,
                           "Duck",
                           "Donald",
                           address02));
    dummyDB.put(new Long(7),
                new Person(7,
                           "Duck",
                           "Trick",
                           address02));
    dummyDB.put(new Long(8),
                new Person(8,
                           "Duck",
                           "Tick",
                           address02));
    dummyDB.put(new Long(9),
                new Person(9,
                           "Duck",
                           "Tack",
                           address02));
    Address address03 = new Address(2,
                                    "Am Goldberg Nr. 1",
                                    "88991",
                                    "Entenhausen");
    dummyDB.put(new Long(10),
                new Person(10,
                           "Duck",
                           "Dagobert",
                           address03));

  }

  @GET
  @Path("/get/{id}")
  @Produces("application/json")
  public PersonGetResponse get(@PathParam("id") String id) {
    Status status = new Status();
    status.setReturnCode(ReturnCode.OK);

    PersonGetResponse response = new PersonGetResponse();
    response.setStatus(status);

    if (dummyDB.containsKey(new Long(id))) {
      System.out.println("Found Person for ID: " + id);
      response.setPerson(dummyDB.get(new Long(id)));
    }

    return response;
  }

  @POST
  @Produces("application/json")
  @Path("/insert")
  public PersonInsertResponse insert(Person person) {
    Iterator<Person> iter = dummyDB.values()
                                   .iterator();
    long maxKey = 0;
    while (iter.hasNext()) {
      Person element = iter.next();
      if (maxKey < element.getId()) {
        maxKey = element.getId();
      }
    }
    maxKey++;
    person.setId(maxKey);
    dummyDB.put(new Long(maxKey),
                person);

    PersonInsertResponse response = new PersonInsertResponse();

    Status status = new Status();
    status.setReturnCode(ReturnCode.OK);
    response.setStatus(status);

    response.setPerson(person);

    return response;
  }

  @POST
  @Produces("application/json")
  @Path("/update")
  public PersonUpdateResponse update(Person person) {
    Person value = dummyDB.get(new Long(person.getId()));
    if (value != null) {
      dummyDB.remove(new Long(person.getId()));
      dummyDB.put(new Long(person.getId()),
                  person);
    }

    PersonUpdateResponse response = new PersonUpdateResponse();

    Status status = new Status();
    status.setReturnCode(ReturnCode.OK);
    response.setStatus(status);

    response.setPerson(person);

    return response;
  }

  @POST
  @Produces("application/json")
  @Path("/search")
  public PersonSearchResponse search(PersonSearch search) {
    PersonSearchResponse response = new PersonSearchResponse();

    Status status = new Status();
    status.setReturnCode(ReturnCode.OK);
    response.setStatus(status);

    List<Person> list = new ArrayList<Person>();
    if ((search.getName() != null && search.getName()
                                           .length() != 0 ) ||
        (search.getCity() != null && search.getCity()
                                                .length() != 0)) {
      for (Long aLong : dummyDB.keySet()) {
        Person Person = dummyDB.get(aLong);
        if (search.getName() != null && search.getName()
                                              .length() != 0 && search.getCity() != null && search.getCity()
                                                                                                  .length() != 0) {
          if (Person.getName()
                    .toLowerCase()
                    .contains(search.getName()
                                    .toLowerCase()) && Person.getAddress()
                                                             .getCity()
                                                             .toLowerCase()
                                                             .contains(search.getCity()
                                                                             .toLowerCase())) {
            list.add(Person);
          }
        } else if (search.getName() != null && search.getName()
                                                     .length() != 0) {
          if (Person.getName()
                    .toLowerCase()
                    .contains(search.getName()
                                    .toLowerCase())) {
            list.add(Person);
          }
        } else if (search.getCity() != null && search.getCity()
                                                     .length() != 0) {
          if (Person.getAddress()
                    .getCity()
                    .toLowerCase()
                    .contains(search.getCity()
                                    .toLowerCase())) {
            list.add(Person);
          }
        }
      }
    }

    response.setPersonList(list);

    return response;
  }
}
