package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.search;

import com.github.mvp4g.domain.dto.shared.search.PersonSearch;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

/**
 * Copyright (C) 2018 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class SearchView
  extends LazyReverseView<ISearchView.Presenter>
  implements ISearchView,
             Editor<PersonSearch> {

  @Path("name")
  TextField searchName;
  @Path("city")
  TextField searchCity;

  private ContentPanel            container;
  private TextButton              searchButton;
  private TextButton              resetButton;

  private Driver driver;

  public SearchView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void edit(PersonSearch personSearch) {
    driver.edit(personSearch);
  }

  @Override
  public void createView() {
    container = new ContentPanel();
    container.setBodyStyle("padding: 12px; backgroundColor: white;");
    container.setBodyBorder(true);

    container.setHeading("Search parameter");

    searchName = new TextField();
    searchCity = new TextField();

    searchButton = new TextButton("Search");
    resetButton = new TextButton("Reset");

    VerticalLayoutContainer vlc = new VerticalLayoutContainer();
    container.setWidget(vlc);

    vlc.add(new FieldLabel(searchName,
                           "Name"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));
    vlc.add(new FieldLabel(searchCity,
                           "City"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    container.getButtonBar()
             .add(searchButton);
    container.getButtonBar()
             .add(resetButton);
  }

  @Override
  public void bind() {
    searchButton.addSelectHandler(e -> {
      getPresenter().doSearch(searchName.getValue(),
                              searchCity.getValue());
    });

    resetButton.addSelectHandler(e -> {
      searchName.setValue("");
      searchCity.setValue("");
    });

    driver = GWT.create(Driver.class);
    driver.initialize(this);
  }

  interface Driver
    extends SimpleBeanEditorDriver<PersonSearch, SearchView> {
  }
}
