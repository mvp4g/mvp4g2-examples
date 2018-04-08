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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationStyleFactory;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;


public class SearchView
  extends LazyReverseView<ISearchView.Presenter>
  implements ISearchView {

  private ScrollPanel    panel;
  private ApplicationCss style;
  private TextField      searchName;
  private TextField      searchCity;
  private Button         searchButton;
  private Button         resetButton;

  public SearchView() {
    super();
    this.style = ApplicationStyleFactory.get().getStyle();
  }

  @Override
  public void setSearch(String searchName, String searchCity) {
    this.searchName.setText(searchName);
    this.searchCity.setText(searchCity);
  }

  public void bind() {
    searchButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        getPresenter().doClickSearchButton(searchName.getText(), searchCity.getText());
      }
    });

    resetButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        searchName.setText("");
        searchCity.setText("");
      }
    });
  }
  
  public void createView() {
    panel = new ScrollPanel();
    
    FlowPanel searchPanel = new FlowPanel();
    searchPanel.addStyleName(style.searchPanel());
    panel.add(searchPanel);
    
    Label headline = new Label(ApplicationConstants.CONSTANTS.searchHeadline());
    headline.addStyleName(style.headline());
    searchPanel.add(headline);
    
    searchName = new TextField(ApplicationConstants.CONSTANTS.searchName());
    searchPanel.add(searchName);
    
    searchCity = new TextField(ApplicationConstants.CONSTANTS.searchCity());
    searchPanel.add(searchCity);
    
    FlowPanel buttonBar = new FlowPanel();
    buttonBar.addStyleName(style.searchPanelButtonBar());
    searchPanel.add(buttonBar);
    
    searchButton = new Button(ApplicationConstants.CONSTANTS.searchButton());
    searchButton.addStyleName(style.button());
    buttonBar.add(searchButton);
     
    resetButton = new Button(ApplicationConstants.CONSTANTS.resetButton());
    resetButton.addStyleName(style.button());
    buttonBar.add(resetButton);
  }

  @Override
  public Widget asWidget() {
    return panel;
  }
}

