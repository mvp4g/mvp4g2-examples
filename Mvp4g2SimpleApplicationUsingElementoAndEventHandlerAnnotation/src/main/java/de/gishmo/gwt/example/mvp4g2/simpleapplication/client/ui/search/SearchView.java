package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;


public class SearchView
  extends LazyReverseView<ISearchView.Presenter>
  implements ISearchView {

  private HTMLDivElement    container;
  private TextField         searchName;
  private TextField         searchCity;
  private HTMLButtonElement searchButton;
  private HTMLButtonElement resetButton;

  public SearchView() {
    super();
  }

  public void createView() {
    container = div().add(div().style("width: 100%;")
                               .add(div().css("headline")
                                         .textContent("Search Parameter (search for: 'S' or 'D')"))
                               .add(searchName = new TextField("Name"))
                               .add(searchCity = new TextField("City"))
                               .add(div().css("buttonBar")
                                         .add(button().css("button")
                                                      .textContent("Search")
                                                      .on(click,
                                                          event -> getPresenter().doClickSearchButton(searchName.getText(),
                                                                                                      searchCity.getText())))
                                         .add(button().css("button")
                                                      .textContent("Reset")
                                                      .on(click,
                                                          event -> {
                                                            searchName.setText("");
                                                            searchCity.setText("");
                                                          }))
                                         .asElement()))
                     .asElement();
  }

  @Override
  public Element asElement() {
    return container;
  }

  @Override
  public void setSearch(String searchName,
                        String searchCity) {
    this.searchName.setText(searchName);
    this.searchCity.setText(searchCity);
  }
}

