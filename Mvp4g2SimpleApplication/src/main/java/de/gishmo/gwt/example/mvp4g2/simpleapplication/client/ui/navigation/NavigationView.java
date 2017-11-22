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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationStyleFactory;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;

public class NavigationView
  extends LazyReverseView<INavigationView.Presenter>
  implements INavigationView {

  private ApplicationCss style;

  private FlowPanel panel;

  private Button searchButton;
  private Button listButton;

  public NavigationView() {
    super();
    this.style = ApplicationStyleFactory.get()
                                        .getStyle();
  }

  public void createView() {
    panel = new FlowPanel();
    panel.addStyleName(style.navigationPanel());

    searchButton = new Button(ApplicationConstants.CONSTANTS.searchFormButton());
    searchButton.addStyleName(style.navigationButton());
    panel.add(searchButton);

    listButton = new Button(ApplicationConstants.CONSTANTS.listFormButton());
    listButton.addStyleName(style.navigationButton());
    panel.add(listButton);
  }

  public void bind() {
    searchButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        getPresenter().doShowSearch();
      }
    });

    listButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        getPresenter().doShowList();
      }
    });
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}
