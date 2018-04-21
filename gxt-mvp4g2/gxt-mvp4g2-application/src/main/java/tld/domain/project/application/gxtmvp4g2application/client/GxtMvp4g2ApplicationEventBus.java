package tld.domain.project.application.gxtmvp4g2application.client;

import com.github.mvp4g.mvp4g2.core.eventbus.IsEventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Debug;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Event;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Start;
import com.github.mvp4g.mvp4g2.core.history.annotation.InitHistory;
import com.github.mvp4g.mvp4g2.core.history.annotation.NotFoundHistory;
import com.google.gwt.user.client.ui.Widget;
import tld.domain.project.application.gxtmvp4g2application.client.history.DefaultHistoryConverter;
import tld.domain.project.application.gxtmvp4g2application.client.ui.header.HeaderPresenter;
import tld.domain.project.application.gxtmvp4g2application.client.ui.navigation.NavigationPresenter;
import tld.domain.project.application.gxtmvp4g2application.client.ui.shell.ShellPresenter;
import tld.domain.project.application.gxtmvp4g2application.client.ui.statusbar.StatusbarPresenter;

/**
 * Copyright (C) 2018 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@EventBus(
    shell = ShellPresenter.class
)
@Debug(
    logLevel = Debug.LogLevel.DETAILED
)
public interface GxtMvp4g2ApplicationEventBus extends IsEventBus {
  /**
   * This event will be fire by the framework as first event
   * of the application.
   *
   * We will use this event to initiate the setting of the
   * navigation in the west area of the shell by using the bind-attribute.
   * By using the start event to bind the navigation, we make sure
   * that the navigation will be updated before the content area is updated.
   */
  @Start
  @Event(
      bind = { NavigationPresenter.class, HeaderPresenter.class, StatusbarPresenter.class }
  )
  void start();

  /**
   * This event will set the element (parameter) in the content
   * area of the shell. We will use this event to update the shell
   * with the current content area.
   *
   * @param widget the element of the widget, that will be
   *               displayed inside the content area of the shell.
   */
  @Event
  void setContent(Widget widget);

  /**
   * This event will set the element (parameter) in the north
   * area of the shell.
   *
   * @param widget the element of the widget, that will be
   *               displayed inside the north area of the shell.
   */
  @Event
  void setHeader(Widget widget);

  /**
   * This event will set the element (parameter) in the west
   * area of the shell.
   *
   * @param widget the element of the widget, that will be
   *               displayed inside the west area of the shell.
   */
  @Event
  void setNavigation(Widget widget);

  /**
   * This event will set the element (parameter) in the south
   * area of the shell.
   *
   * @param widget the element of the widget, that will be
   *               displayed inside the south area of the shell.
   */
  @Event
  void setStatusbar(Widget widget);

  /**
   * This event will be used in case:
   *
   * * there is not history-token
   * * the token is not valid
   */
  @InitHistory
  @NotFoundHistory
  @Event
  void initHistory();

  /**
   * This event will display the detail screen inside the content of
   * the shell. The given id will be used to get the person from server
   * and display the view with the data, read rom the server.
   *
   * We use the DetailHistoryConverter to convert the event to
   *  the token which the framework will display after the url.
   *
   * We will use the String representated by HistoryName.DETAIL
   * instead the event name inside the token.
   *
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   */
  @Event(
      historyName = "R2D2",
      historyConverter = DefaultHistoryConverter.class,
      navigationEvent = true
  )
  void gotoSearch(String searchName,
                  String searchCity);

  /**
   * This event will display the detail screen inside the content of
   * the shell. The given id will be used to get the person from server
   * and display the view with the data, read rom the server.
   *
   * We use the DetailHistoryConverter to convert the event to
   *  the token which the framework will display after the url.
   *
   * We will use the String representated by HistoryName.DETAIL
   * instead the event name inside the token.
   *
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   */
  @Event(
      historyName = "C3P0",
      historyConverter = DefaultHistoryConverter.class,
      navigationEvent = true
  )
  void gotoList(String searchName,
                String searchCity);

  /**
   * This event will display the detail screen inside the content of
   * the shell. The given id will be used to get the person from server
   * and display the view with the data, read rom the server.
   *
   * We use the DetailHistoryConverter to convert the event to
   *  the token which the framework will display after the url.
   *
   * We will use the String representated by HistoryName.DETAIL
   * instead the event name inside the token.
   *
   * This event will change the screen displayed inside the
   * content area. From the mvp4g2 point of view, it is a
   * navigation event. If there is a confirm-presenter defined,
   * this presenter will be asked before the view changed.
   */
  @Event(
      historyName = "BB8",
      historyConverter = DefaultHistoryConverter.class,
      navigationEvent = true
  )
  void gotoDetail(long id);
}
