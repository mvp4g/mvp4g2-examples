package de.gishmo.gwt.example.mvp4g2.simpleapplication.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Address;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.exception.PersonNotFoundException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.*;

@SuppressWarnings("serial")
public class PersonServiceImpl
  extends RemoteServiceServlet
  implements PersonService {

  private static Map<Long, Person> persons;

  public void init(ServletConfig config)
    throws ServletException {
    super.init(config);

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

  @Override
  public Person get(long id)
    throws PersonNotFoundException {
    if (persons.containsKey(new Long(id))) {
      return persons.get(id);
    } else {
      throw new PersonNotFoundException("no data found for ID >>" + Long.toString(id) + "<<");
    }
  }

  @Override
  public List<Person> getAll() {
    List<Person> list = new ArrayList<Person>();
    Iterator<Long> iterator = persons.keySet()
                                     .iterator();
    while (iterator.hasNext()) {
      list.add(persons.get(iterator.next()));
    }
    return list;
  }

  @Override
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

  @Override
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

  @Override
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
