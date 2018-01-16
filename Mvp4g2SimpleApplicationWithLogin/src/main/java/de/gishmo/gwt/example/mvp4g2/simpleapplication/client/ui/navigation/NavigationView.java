/*
 * Copyright (C) 2016 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.navigation;

import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class NavigationView
  extends LazyReverseView<INavigationView.Presenter>
  implements INavigationView {

  private HTMLButtonElement searchButton;
  private HTMLButtonElement listButton;
  private HTMLButtonElement logoutButton;
  private HTMLDivElement    container;

  public NavigationView() {
    super();
  }

  public void createView() {
    searchButton = searchButton = button().css("navigationButton")
                                          .textContent("Search")
                                          .on(click,
                                              event -> getPresenter().doShowSearch())
                                          .asElement();
    listButton = button().css("navigationButton")
                         .textContent("List")
                         .on(click,
                             event -> getPresenter().doShowList())
                         .asElement();
    logoutButton = button().css("navigationButton")
                           .textContent("Logout")
                           .on(click,
                               event -> getPresenter().doLogout())
                           .asElement();

    container = div().add(searchButton)
                     .add(listButton)
                     .add(logoutButton)
                     .asElement();
  }

  @Override
  public Element asElement() {
    return container;
  }
}
