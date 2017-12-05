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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler.SimpleApplicationHandler;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history.DefaultHistoryConverter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail.DetailPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list.ListPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.navigation.NavigationPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search.SearchPresenter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.shell.ShellPresenter;
import de.gishmo.gwt.mvp4g2.client.eventbus.IsEventBus;
import de.gishmo.gwt.mvp4g2.client.eventbus.annotation.Debug;
import de.gishmo.gwt.mvp4g2.client.eventbus.annotation.Event;
import de.gishmo.gwt.mvp4g2.client.eventbus.annotation.EventBus;
import de.gishmo.gwt.mvp4g2.client.eventbus.annotation.Start;
import de.gishmo.gwt.mvp4g2.client.history.annotation.InitHistory;
import de.gishmo.gwt.mvp4g2.client.history.annotation.NotFoundHistory;
import elemental2.dom.Element;

/**
 * Event bus of the SimpleMvp4G2Application example
 */
@EventBus(shell = ShellPresenter.class, historyOnStart = true)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2SimpleApplicationEventBus
  extends IsEventBus {

  @Start
  @Event(bind = {NavigationPresenter.class})
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
    historyConverter = DefaultHistoryConverter.class,
    navigationEvent = true)
  void gotoDetail(long id);

  @Event(handlers = {ListPresenter.class},
    activate = {SimpleApplicationHandler.class},
    historyConverter = DefaultHistoryConverter.class,
    navigationEvent = true)
  void gotoList(String searchName,
                String searchOrt);

  @InitHistory
  @NotFoundHistory
  @Event(handlers = {SearchPresenter.class},
    historyConverter = DefaultHistoryConverter.class,
    navigationEvent = true)
  void initHistory();

  @Event(handlers = {SearchPresenter.class},
    historyConverter = DefaultHistoryConverter.class,
    navigationEvent = true)
  void gotoSearch(String searchName,
                  String searchOrt);

}
