package de.gishmo.example.mvp4g2.springboot.server.resource;

import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Address;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.PersonSearch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Due to the fact, that there is currently no J2Cl based server framework and to proof mvp4g2 is working,
 * There is no need to do real server calls. So, we will simulate the server calls, to concentrate on
 * mvp4g2.
 * <p>
 * It is up to you to decide which way you use to talk to the server!
 * <p>
 * For the example it does matter, if we retrieve the data form a server mock or a client mock!
 */
@RestController
@RequestMapping("/services/person")
public class PersonResource {

  private Map<Long, Person> persons;

  private PersonResource() {
    if (persons == null) {
      persons = new HashMap<Long, Person>();
      initList();
    }
  }

  private void initList() {
    Address address01 = new Address(1,
                                    "Evergreen Terrace",
                                    "7 42",
                                    "Springfield");
    persons.put(new Long(1),
                new Person(1,
                           "Simpsons",
                           "Homer",
                           address01));
    persons.put(new Long(2),
                new Person(2,
                           "Simpsons",
                           "Marge",
                           address01));
    persons.put(new Long(3),
                new Person(3,
                           "Simpsons",
                           "Bart",
                           address01));
    persons.put(new Long(4),
                new Person(4,
                           "Simpsons",
                           "Maggie",
                           address01));
    persons.put(new Long(5),
                new Person(5,
                           "Simpsons",
                           "Lisa",
                           address01));
    Address address02 = new Address(2,
                                    "Blumenweg Nr. 13",
                                    "",
                                    "Entenhausen");
    persons.put(new Long(6),
                new Person(6,
                           "Duck",
                           "Donald",
                           address02));
    persons.put(new Long(7),
                new Person(7,
                           "Duck",
                           "Trick",
                           address02));
    persons.put(new Long(8),
                new Person(8,
                           "Duck",
                           "Tick",
                           address02));
    persons.put(new Long(9),
                new Person(9,
                           "Duck",
                           "Tack",
                           address02));
    Address address03 = new Address(2,
                                    "Am Goldberg Nr. 1",
                                    "",
                                    "Entenhausen");
    persons.put(new Long(10),
                new Person(10,
                           "Duck",
                           "Dagobert",
                           address03));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/get")
  @ResponseBody
  public ResponseEntity<Person> get(@QueryParam("id") String id) {
    long idLong = Long.parseLong(id);
    if (persons.containsKey(new Long(idLong))) {
      return new ResponseEntity<>(persons.get(idLong),
                                  HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/getAll")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public List<Person> getAll() {
    List<Person> list = new ArrayList<>();
    Iterator<Long> iterator = persons.keySet()
                                     .iterator();
    while (iterator.hasNext()) {
      list.add(persons.get(iterator.next()));
    }
    return list;
  }

  @RequestMapping(method = RequestMethod.POST, path = "/search")
  @ResponseBody
  public ResponseEntity<List<Person>> search(@RequestBody PersonSearch search) {
    List<Person> list = new ArrayList<Person>();
    if ((search.getName() != null && search.getName()
                                           .length() != 0
        ) ||
        (search.getCity() != null && search.getCity()
                                           .length() != 0
        )) {
      Iterator<Long> iterator = persons.keySet()
                                       .iterator();
      while (iterator.hasNext()) {
        Person person = persons.get(iterator.next());
        if (search.getName() != null && search.getName()
                                              .length() != 0 &&
            search.getCity() != null && search.getCity()
                                              .length() != 0) {
          if (person.getName()
                    .toLowerCase()
                    .contains(search.getName()
                                    .toLowerCase()) &&
              person.getAddress()
                    .getCity()
                    .toLowerCase()
                    .contains(search.getCity()
                                    .toLowerCase())) {
            list.add(person);
          }
        } else if (search.getName() != null && search.getName()
                                                     .length() != 0) {
          if (person.getName()
                    .toLowerCase()
                    .contains(search.getName()
                                    .toLowerCase())) {
            list.add(person);
          }
        } else if (search.getCity() != null && search.getCity()
                                                     .length() != 0) {
          if (person.getAddress()
                    .getCity()
                    .toLowerCase()
                    .contains(search.getCity()
                                    .toLowerCase())) {
            list.add(person);
          }
        }
      }
    }
    return new ResponseEntity<>(list,
                                HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, path = "/insert")
  @ResponseStatus(HttpStatus.OK)
  @ResponseBody
  public void insert(@RequestBody Person person) {
    Iterator<Person> iter = persons.values()
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
    persons.put(new Long(maxKey),
                person);
  }

  @RequestMapping(method = RequestMethod.POST, path = "/update")
  @ResponseBody
  public ResponseEntity<Void> update(@RequestBody Person person) {
    Person value = persons.get(new Long(person.getId()));
    if (value != null) {
      persons.remove(new Long(person.getId()));
      persons.put(new Long(person.getId()),
                  person);
    }
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
