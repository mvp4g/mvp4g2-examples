package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.UiUtils;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;
import elemental2.dom.*;

import java.util.List;

import static elemental2.dom.DomGlobal.document;

public class ListView
  extends LazyReverseView<IListView.Presenter>
  implements IListView {

  private HTMLDivElement   panel;
  private HTMLDivElement   listPanel;
  private HTMLTableElement resultTable;
  private HTMLElement      tableBody;

  public ListView() {
    super();
  }

  public void createView() {
    panel = (HTMLDivElement) document.createElement("div");

    listPanel = (HTMLDivElement) document.createElement("div");
    listPanel.className = "resultPanel";
    panel.appendChild(listPanel);

    HTMLDivElement headline = (HTMLDivElement) document.createElement("div");
    headline.innerHTML = "Search Results";
    UiUtils.setUpHeadline(headline);
    listPanel.appendChild(headline);
  }

  @Override
  public Element asElement() {
    return panel;
  }

  @Override
  public void resetTable() {
    if (resultTable != null) {
      listPanel.removeChild(resultTable);
      resultTable = null;
    }
  }

  @Override
  public void setData(List<Person> result) {
    resetTable();
    listPanel.appendChild(createTable(result));
  }

  private HTMLTableElement createTable(List<Person> result) {
    resultTable = (HTMLTableElement) document.createElement("table");
    resultTable.style.display = "table";
    resultTable.style.borderCollapse = "seperate";
    resultTable.style.borderSpacing = "2px";
    resultTable.style.borderColor = "grey";
    resultTable.style.fontFamily = "Arial, sans-serif";
    resultTable.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    resultTable.style.margin = CSSProperties.MarginUnionType.of("12px");

    resultTable.style.width = CSSProperties.WidthUnionType.of("100%");
    listPanel.appendChild(resultTable);

    HTMLElement colGroup = (HTMLElement) document.createElement("colgroup");
    resultTable.appendChild(colGroup);
    colGroup.appendChild(this.createColElement("40%"));
    colGroup.appendChild(this.createColElement("25%"));
    colGroup.appendChild(this.createColElement("10%"));
    colGroup.appendChild(this.createColElement("25%"));

    HTMLElement tableHeadGroud = (HTMLElement) document.createElement("thead");
    resultTable.appendChild(tableHeadGroud);
    HTMLElement trHead = (HTMLElement) document.createElement("tr");
    tableHeadGroud.appendChild(trHead);
    tableHeadGroud.appendChild(this.createTableHeaderElement("Name"));
    tableHeadGroud.appendChild(this.createTableHeaderElement("Street"));
    tableHeadGroud.appendChild(this.createTableHeaderElement("ZIP"));
    tableHeadGroud.appendChild(this.createTableHeaderElement("City"));

    for (Person person : result) {
      resultTable.appendChild(this.createTableDataRow(person));
    }

    return resultTable;
  }

  private HTMLTableColElement createColElement(String width) {
    HTMLTableColElement colElement = (HTMLTableColElement) document.createElement("col");
    colElement.style.width = CSSProperties.WidthUnionType.of(width);
    return colElement;
  }

  private HTMLElement createTableHeaderElement(String name) {
    HTMLElement element = (HTMLElement) document.createElement("th");
    element.innerHTML = name;
    element.className = "cellTableHeader";
    element.style.fontWeight = "bold";
    element.style.fontSize = CSSProperties.FontSizeUnionType.of("16px");
    element.style.borderBottom = "2px solid darkgray";
    return element;
  }

  private HTMLElement createTableDataRow(Person person) {
    HTMLElement trElement = (HTMLElement) document.createElement("tr");

    HTMLElement nameCell = (HTMLElement) document.createElement("td");
    trElement.appendChild(nameCell);
    HTMLDivElement clickableMNameCell = (HTMLDivElement) document.createElement("div");
    nameCell.appendChild(clickableMNameCell);
    clickableMNameCell.innerHTML = person.getName() + ", " + person.getFirstName();
    clickableMNameCell.style.fontWeight = "bold";
    clickableMNameCell.style.textDecoration = "underline";
    clickableMNameCell.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    clickableMNameCell.addEventListener("click",
                                        (e) -> {
                                          getPresenter().doUpdate(person);
                                        });

    HTMLElement streetCell = (HTMLElement) document.createElement("td");
    streetCell.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    streetCell.innerHTML = person.getAddress()
                                 .getStreet();
    trElement.appendChild(streetCell);

    HTMLElement zipCell = (HTMLElement) document.createElement("td");
    zipCell.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    zipCell.innerHTML = person.getAddress()
                              .getZip();
    trElement.appendChild(zipCell);

    HTMLElement cityCell = (HTMLElement) document.createElement("td");
    cityCell.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    cityCell.innerHTML = person.getAddress()
                               .getCity();
    trElement.appendChild(cityCell);

    return trElement;
  }
}
