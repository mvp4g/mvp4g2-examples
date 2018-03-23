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

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.UiUtils;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;

import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static elemental2.dom.DomGlobal.document;

public class NavigationView
  extends LazyReverseView<INavigationView.Presenter>
  implements INavigationView {

  private HTMLDivElement panel;

  HTMLButtonElement searchButton;
  HTMLButtonElement listButton;

  public NavigationView() {
    super();
  }

  public void createView() {
    panel = (HTMLDivElement) document.createElement("div");

    searchButton = (HTMLButtonElement) document.createElement("button");
    searchButton.textContent = "Search";
    UiUtils.setUpNavigationButton(searchButton);
    panel.appendChild(searchButton);

    listButton = (HTMLButtonElement) document.createElement("button");
    listButton.textContent = "List";
    UiUtils.setUpNavigationButton(listButton);
    panel.appendChild(listButton);
  }

  public void bind() {
    searchButton.addEventListener("click",
                                  (e) -> {
                                    getPresenter().doShowSearch();
                                  });

    listButton.addEventListener("click",
                                (e) -> {
                                  getPresenter().doShowList();
                                });
  }

  @Override
  public Element asElement() {
    return panel;
  }
}
