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

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history.DetailHistoryConverter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history.HistoryName;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history.ListHistoryConverter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history.SearchHistoryConverter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.shell.ShellPresenter;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Debug;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Event;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Start;
import com.github.mvp4g.mvp4g2.core.history.annotation.InitHistory;
import com.github.mvp4g.mvp4g2.core.history.annotation.NotFoundHistory;
import elemental2.dom.Element;

/**
 * Event bus of the SimpleMvp4G2Application example
 */
@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2SimpleApplicationWithLoginEventBus
  extends IsEventBus {

  @Start
  @Event
  void start();

  @Event
  void setUpShell();

  @Event
  void setNavigation(Element element);

  @Event
  void setContent(Element element);

  @Event
  void setStatus(String status);

  @Event(historyConverter = DetailHistoryConverter.class, historyName = HistoryName.DETAIL, navigationEvent = true)
  void gotoDetail(long id);

  @Event(historyConverter = ListHistoryConverter.class, historyName = HistoryName.LIST, navigationEvent = true)
  void gotoList(String searchName,
                String searchOrt);

  @InitHistory
  @NotFoundHistory
  @Event
  void initHistory();

  @Event(historyConverter = SearchHistoryConverter.class, historyName = HistoryName.SEARCH, navigationEvent = true)
  void gotoSearch(String searchName,
                  String searchOrt);

  @Event
  void login();

  @Event
  void noValidLogin();

  @Event
  void gotoLogin();

}
