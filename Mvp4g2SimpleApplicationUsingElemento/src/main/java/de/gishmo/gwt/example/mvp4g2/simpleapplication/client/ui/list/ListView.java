package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.col;
import static org.jboss.gwt.elemento.core.Elements.colgroup;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.table;
import static org.jboss.gwt.elemento.core.Elements.td;
import static org.jboss.gwt.elemento.core.Elements.th;
import static org.jboss.gwt.elemento.core.Elements.thead;
import static org.jboss.gwt.elemento.core.Elements.tr;
import static org.jboss.gwt.elemento.core.EventType.click;

public class ListView
  extends LazyReverseView<IListView.Presenter>
  implements IListView {

  private HTMLElement container;
  private HTMLElement resultTable;

  public ListView() {
    super();
  }

  public void createView() {
    container = div().add(div().style("width: 100%"))
                     .add(div().css("headline")
                               .textContent("Search Results"))
                     .asElement();
  }

  @Override
  public Element asElement() {
    return container;
  }

  @Override
  public void resetTable() {
    if (resultTable != null) {
      container.removeChild(resultTable);
      resultTable = null;
    }
  }

  @Override
  public void setData(List<Person> result) {
    resetTable();
    container.appendChild(createTable(result));
  }

  private HTMLElement createTable(List<Person> result) {
    resultTable = table().css("resultTable")
                         .add(colgroup().add(col().style("width: 40%;")
                                                  .asElement())
                                        .add(col().style("width: 25%;")
                                                  .asElement())
                                        .add(col().style("width: 10%;")
                                                  .asElement())
                                        .add(col().style("width: 25%;")
                                                  .asElement()))
                         .add(thead().add(th().css("resultTableHeader")
                                              .textContent("Name")
                                              .asElement())
                                     .add(th().css("resultTableHeader")
                                              .textContent("Street")
                                              .asElement())
                                     .add(th().css("resultTableHeader")
                                              .textContent("Zip")
                                              .asElement())
                                     .add(th().css("resultTableHeader")
                                              .textContent("City")
                                              .asElement()))
                         .asElement();

    for (Person person : result) {
      resultTable.appendChild(this.createTableDataRow(person));
    }

    return resultTable;
  }

  private HTMLElement createTableDataRow(Person person) {
    return tr().add(td().add(div().css("resultTableLink")
                                  .textContent(person.getName() + ", " + person.getFirstName())
                                  .on(click,
                                      (event) -> getPresenter().doUpdate(person))))
               .add(td().textContent(person.getAddress()
                                           .getStreet())
                        .asElement())
               .add(td().textContent(person.getAddress()
                                           .getZip())
                        .asElement())
               .add(td().textContent(person.getAddress()
                                           .getCity())
                        .asElement())
               .asElement();
  }
}
