package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.list;

import java.util.List;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;

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

  private ContentPanel            container;

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

    container.setBodyStyle("padding: 12px; backgroundColor: white;");
    container.setBodyBorder(true);

    container.setHeading("Persons List");

  }

  @Override
  public void bind() {

  }

  @Override
  public void edit(List<Person> personList) {

  }
}
