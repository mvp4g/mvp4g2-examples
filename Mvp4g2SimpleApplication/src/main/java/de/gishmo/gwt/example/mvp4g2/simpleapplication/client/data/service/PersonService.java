package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Address;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonNotFoundException;

import java.util.*;

/**
 * Due to the fact, that there is currently no J2Cl based server framework and to proof mvp4g2 is working,
 * There is no need to do real server calls. So, we will sumulate the server calls, to concentrate on
 * mvp4g2.
 */
public class PersonService {

  private static PersonService instance;

  private Map<Long, Person> persons;

  private PersonService() {
    if (persons == null) {
      persons = new HashMap<Long, Person>();
      initList();
    }
  }

  public static PersonService get() {
    if (instance == null) {
      instance = new PersonService();
    }
    return instance;
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

  public Person get(long id)
    throws PersonNotFoundException {
    if (persons.containsKey(new Long(id))) {
      return persons.get(id);
    } else {
      throw new PersonNotFoundException("no data found for ID >>" + Long.toString(id) + "<<");
    }
  }

  public List<Person> getAll() {
    List<Person> list = new ArrayList<Person>();
    Iterator<Long> iterator = persons.keySet()
                                     .iterator();
    while (iterator.hasNext()) {
      list.add(persons.get(iterator.next()));
    }
    return list;
  }

  public List<Person> get(PersonSearch search) {
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
    return list;
  }

  public void insert(Person person)
    throws PersonException {
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

  public void update(Person person)
    throws PersonException {
    Person value = persons.get(new Long(person.getId()));
    if (value != null) {
      persons.remove(new Long(person.getId()));
      persons.put(new Long(person.getId()),
                  person);
    }
  }
}
