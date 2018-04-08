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

package de.gishmo.gwt.example.mvp4g2.springboot.client.ui.navigation;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class NavigationView
  extends LazyReverseView<INavigationView.Presenter>
  implements INavigationView {

  HTMLButtonElement searchButton;
  HTMLButtonElement listButton;
  private HTMLDivElement container;

  public NavigationView() {
    super();
  }

  public void createView() {
    container = div().add(searchButton = button().css("navigationButton")
                                                 .textContent("Search")
                                                 .on(click,
                                                     event -> getPresenter().doShowSearch())
                                                 .asElement())
                     .add(listButton = button().css("navigationButton")
                                               .textContent("List")
                                               .on(click,
                                                   event -> getPresenter().doShowList())
                                               .asElement())
                     .asElement();
  }

  @Override
  public Element asElement() {
    return container;
  }
}
