package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.navigation;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

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
public class NavigationView
  extends LazyReverseView<INavigationView.Presenter>
  implements INavigationView {
  private VerticalLayoutContainer container;

  public NavigationView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void createView() {
    container = new VerticalLayoutContainer();
    TextButton textButtonsearch = new TextButton("Search Persons");
    textButtonsearch.addSelectHandler(new SelectEvent.SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {
        getPresenter().doNavigateTo("search");
      }
    });
    container.add(textButtonsearch,
                  new VerticalLayoutContainer.VerticalLayoutData(1,
                                                                 -1,
                                                                 new Margins(12)));
    TextButton textButtonlist = new TextButton("List Persons");
    textButtonlist.addSelectHandler(new SelectEvent.SelectHandler() {
      @Override
      public void onSelect(SelectEvent event) {
        getPresenter().doNavigateTo("list");
      }
    });
    container.add(textButtonlist,
                  new VerticalLayoutContainer.VerticalLayoutData(1,
                                                                 -1,
                                                                 new Margins(12)));
  }
}
