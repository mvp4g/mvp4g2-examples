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

package de.gishmo.gwt.example.mvp4g2.springboot.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;

import java.util.List;

public interface IListView
  extends IsLazyReverseView<IListView.Presenter> {

  /**
   * mvp4g2 does not know Widget-, Element- or any other class. So, the
   * presenter have to manage the widget by themselves. The method will
   * enable the presenter to get the view. (In our case it is a
   * Elemental 2 element!)
   *
   * @return The list element
   */
  Element asElement();

  void resetTable();

  void setData(List<Person> result);

  public interface Presenter {

    void doUpdate(Person object);

  }
}
