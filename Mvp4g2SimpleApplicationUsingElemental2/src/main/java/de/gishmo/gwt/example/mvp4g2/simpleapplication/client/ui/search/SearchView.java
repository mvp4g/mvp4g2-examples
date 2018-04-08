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

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.UiUtils;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;

import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static elemental2.dom.DomGlobal.document;


public class SearchView
  extends LazyReverseView<ISearchView.Presenter>
  implements ISearchView {

  private HTMLDivElement    panel;
  private TextField         searchName;
  private TextField         searchCity;
  private HTMLButtonElement searchButton;
  private HTMLButtonElement resetButton;

  public SearchView() {
    super();
  }

  @Override
  public void setSearch(String searchName,
                        String searchCity) {
    this.searchName.setText(searchName);
    this.searchCity.setText(searchCity);
  }

  public void bind() {
    searchButton.addEventListener("click", (e) -> {
      getPresenter().doClickSearchButton(searchName.getText(),
                                         searchCity.getText());
    });

    resetButton.addEventListener("click", (e) -> {
      searchName.setText("");
      searchCity.setText("");
    });
  }

  public void createView() {
    panel = (HTMLDivElement) document.createElement("div");

    HTMLDivElement searchPanel = (HTMLDivElement) document.createElement("div");
    searchPanel.style.width = CSSProperties.WidthUnionType.of("100%");
    panel.appendChild(searchPanel);

    HTMLDivElement headline = (HTMLDivElement) document.createElement("div");
    headline.innerHTML = "Search Parameter (search for: 'S' or 'D')";
    UiUtils.setUpHeadline(headline);
    searchPanel.appendChild(headline);

    searchName = new TextField("Name");
    searchPanel.appendChild(searchName.getElement());

    searchCity = new TextField("City");
    searchPanel.appendChild(searchCity.getElement());

    HTMLDivElement buttonBar = (HTMLDivElement) document.createElement("div");
    buttonBar.style.cssFloat = "left";
    buttonBar.style.textAlign = "right";
    buttonBar.style.width = CSSProperties.WidthUnionType.of("100%");
    searchPanel.appendChild(buttonBar);

    searchButton = (HTMLButtonElement) document.createElement("button");
    searchButton.textContent = "Search";
    UiUtils.setUButton(searchButton);
    buttonBar.appendChild(searchButton);

    resetButton = (HTMLButtonElement) document.createElement("button");
    resetButton.textContent = "Reset";
    UiUtils.setUButton(resetButton);
    buttonBar.appendChild(resetButton);
  }

  @Override
  public Element asElement() {
    return panel;
  }
}

