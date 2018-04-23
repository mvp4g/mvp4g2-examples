package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.detail;

import com.github.mvp4g.domain.dto.shared.model.Person;
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
public class DetailView
    extends LazyReverseView<IDetailView.Presenter>
    implements IDetailView,
               Editor<Person> {

  @Path("name")
  TextField name;

  @Path("firstName")
  TextField firstName;

  @Path("address.street")
  TextField street;

  @Path("address.zip")
  TextField zip;

  @Path("address.city")
  TextField city;

  private ContentPanel container;

  private TextButton saveButton;

  private TextButton cancelButton;

  private Driver driver;

  public DetailView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void bind() {
    saveButton.addSelectHandler(e -> getPresenter().doSave(driver.flush()));
    cancelButton.addSelectHandler(e -> getPresenter().doCancel());

    driver = GWT.create(Driver.class);
    driver.initialize(this);
  }

  @Override
  public boolean isDirty() {
    return driver.isDirty();
  }

  @Override
  public void edit(Person person,
                   boolean isNew) {
    driver.edit(person);
  }

  @Override
  public void createView() {
    container = new ContentPanel();
    container.setHeading("Person Details");
    container.setBodyStyle("padding: 12px; backgroundColor: white;");
    container.setBodyBorder(true);

    name = new TextField();
    firstName = new TextField();
    street = new TextField();
    zip = new TextField();
    city = new TextField();

    saveButton = new TextButton("Save");
    cancelButton = new TextButton("Cancel");

    VerticalLayoutContainer vlc = new VerticalLayoutContainer();
    container.setWidget(vlc);

    vlc.add(new FieldLabel(name,
                           "Name"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));
    vlc.add(new FieldLabel(firstName,
                           "First Name"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));
    vlc.add(new FieldLabel(street,
                           "Street"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));
    vlc.add(new FieldLabel(zip,
                           "ZIP"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));
    vlc.add(new FieldLabel(city,
                           "City"),
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    container.getButtonBar()
             .add(saveButton);
    container.getButtonBar()
             .add(cancelButton);
  }

  interface Driver
      extends SimpleBeanEditorDriver<Person, DetailView> {
  }
}
