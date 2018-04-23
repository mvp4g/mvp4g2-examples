package com.github.mvp4g2.application.gxtmvp4g2application.client.model.provider;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface PersonProperties
    extends PropertyAccess<Person> {

  @Editor.Path("id")
  ModelKeyProvider<Person> key();

  @Editor.Path("name")
  ValueProvider<Person, String> name();

  @Editor.Path("firstName")
  ValueProvider<Person, String> firstName();

  @Editor.Path("address.street")
  ValueProvider<Person, String> street();

  @Editor.Path("address.zip")
  ValueProvider<Person, String> zip();

  @Editor.Path("address.city")
  ValueProvider<Person, String> city();
}
