package com.github.mvp4g.server.resource;

import com.github.mvp4g.domain.dto.shared.model.Address;
import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.domain.dto.shared.search.PersonSearch;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.*;

@Singleton
@Path("/Person")
public class PersonResource {

  private static Map<Long, Person> dummyDB;

  public PersonResource() {
    init();
  }

  private void init() {
    dummyDB = new HashMap<>();
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
  public Person get(@PathParam("id") String id) {
    if (dummyDB.containsKey(new Long(id))) {
      System.out.println("Found Person for ID: " + id);
      return dummyDB.get(new Long(id));
    }
    return null;
  }

  @POST
  @Produces("application/json")
  @Path("/insert")
  public void insert(Person person) {
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
  }

  @POST
  @Produces("application/json")
  @Path("/update")
  public void update(Person person) {
    Person value = dummyDB.get(new Long(person.getId()));
    if (value != null) {
      dummyDB.remove(new Long(person.getId()));
      dummyDB.put(new Long(person.getId()),
                  person);
    }
  }

  @POST
  @Produces("application/json")
  @Path("/search")
  public List<Person> search(PersonSearch search) {
    List<Person> list = new ArrayList<Person>();
    if ((search.getName() != null && search.getName()
                                           .length() != 0) || (search.getCity() != null && search.getCity()
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
    return list;
  }
}
