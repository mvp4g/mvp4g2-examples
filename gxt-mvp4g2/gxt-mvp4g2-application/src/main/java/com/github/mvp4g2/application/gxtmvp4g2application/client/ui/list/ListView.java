package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.list;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.github.mvp4g2.application.gxtmvp4g2application.client.model.provider.PersonProperties;
import com.github.mvp4g2.application.gxtmvp4g2application.client.resources.ImageResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.toolbar.ToolBar;

import java.util.ArrayList;
import java.util.List;

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
public class ListView
    extends LazyReverseView<IListView.Presenter>
    implements IListView {

  private ContentPanel container;

  private VerticalLayoutContainer vlc;

  private ListStore<Person> store;

  private Grid<Person> grid;

  private ToolBar toolbar;

  private TextButton newButton;

  private TextButton editButton;

  private PersonProperties props = GWT.create(PersonProperties.class);

  public ListView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void createView() {
    container = new ContentPanel();

    container.setBodyStyle("backgroundColor: white;");
    container.setBodyBorder(true);

    vlc = new VerticalLayoutContainer();
    container.add(vlc);

    container.setHeading("Persons List");

    ToolBar tb = new ToolBar();
    newButton = new TextButton();
    newButton.setIcon(ImageResources.IMAGES.iconNew());
    editButton = new TextButton();
    editButton.setIcon(ImageResources.IMAGES.iconEdit());
    tb.add(newButton);
    tb.add(editButton);
    vlc.add(tb,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    createGrid();
    vlc.add(grid,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           266,
                                                           new Margins(12)));
  }

  private void createGrid() {
    store = new ListStore<>(props.key());

    IdentityValueProvider<Person> identity = new IdentityValueProvider<Person>();
    final CheckBoxSelectionModel<Person> selectionModel = new CheckBoxSelectionModel<Person>(identity);

    ColumnConfig<Person, String> ccName = new ColumnConfig<>(props.name(),
                                                             200,
                                                             "Name");
    ColumnConfig<Person, String> ccFirstName = new ColumnConfig<>(props.firstName(),
                                                                  200,
                                                                  "First Name");
    ColumnConfig<Person, String> ccStreet = new ColumnConfig<>(props.street(),
                                                               200,
                                                               "Street");
    ColumnConfig<Person, String> ccZip = new ColumnConfig<>(props.zip(),
                                                            100,
                                                            "ZIP");
    ColumnConfig<Person, String> ccCity = new ColumnConfig<>(props.city(),
                                                             200,
                                                             "City");

    List<ColumnConfig<Person, ?>> list = new ArrayList<>();
    list.add(selectionModel.getColumn());
    list.add(ccName);
    list.add(ccFirstName);
    list.add(ccStreet);
    list.add(ccZip);
    list.add(ccCity);
    ColumnModel<Person> cm = new ColumnModel<>(list);
    grid = new Grid<>(store,
                      cm);
    grid.setSelectionModel(selectionModel);
    grid.getSelectionModel()
        .setSelectionMode(Style.SelectionMode.SINGLE);
    grid.setSize("100%",
                 "256px");
    grid.getView()
        .setStripeRows(true);
    grid.setBorders(false);
    grid.getView()
        .setAutoExpandColumn(ccName);
    grid.getView()
        .setForceFit(true);
    grid.setBorders(true);
  }

  @Override
  public void bind() {
    newButton.addSelectHandler(e -> getPresenter().doNew());
    editButton.addSelectHandler(e -> getPresenter().doEdit(grid.getSelectionModel()
                                                              .getSelectedItem()));

  }

  @Override
  public void edit(List<Person> personList) {
    store.clear();
    store.addAll(personList);
  }
}
