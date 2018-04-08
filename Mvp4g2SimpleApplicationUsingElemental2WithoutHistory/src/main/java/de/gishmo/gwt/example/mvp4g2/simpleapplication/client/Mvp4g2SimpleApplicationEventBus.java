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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler.SimpleApplicationHandler;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail.DetailPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list.ListPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.navigation.NavigationPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search.SearchPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.shell.ShellPresenter;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Debug;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Event;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Start;
import elemental2.dom.Element;

/**
 * Event bus of the SimpleMvp4G2Application example
 */
@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2SimpleApplicationEventBus
  extends IsEventBus {

  @Start
  @Event(bind = {NavigationPresenter.class},
    handlers = SearchPresenter.class)
  public void start();

  @Event(handlers = {ShellPresenter.class,
                     SimpleApplicationHandler.class})
  void setNavigation(Element element);

  @Event(handlers = ShellPresenter.class)
  void setContent(Element element);

  @Event(handlers = ShellPresenter.class)
  void setStatus(String status);

  @Event(handlers = DetailPresenter.class,
    deactivate = {SimpleApplicationHandler.class},
    navigationEvent = true)
  void gotoDetail(long id);

  @Event(handlers = {ListPresenter.class},
    activate = {SimpleApplicationHandler.class},
    navigationEvent = true)
  void gotoList(String searchName,
                String searchOrt);

  @Event(handlers = {SearchPresenter.class},
    navigationEvent = true)
  void gotoSearch(String searchName,
                  String searchOrt);

}
