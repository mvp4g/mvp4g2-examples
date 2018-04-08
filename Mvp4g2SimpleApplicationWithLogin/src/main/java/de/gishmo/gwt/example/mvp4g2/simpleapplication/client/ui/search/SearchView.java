/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
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

