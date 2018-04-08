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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.LoginFilter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationWithLoginEventBus;
import com.github.mvp4g.mvp4g2.core.ui.AbstractHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Handler;
import elemental2.dom.DomGlobal;

import static elemental2.dom.DomGlobal.alert;

@Handler
public class SimpleApplicationHandler02
  extends AbstractHandler<Mvp4g2SimpleApplicationWithLoginEventBus> {

  private LoginFilter loginFilter;

  public SimpleApplicationHandler02() {
    loginFilter = new LoginFilter();
  }

  @EventHandler
  public void onStart() {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> handling start event");
  }

  @EventHandler
  public void onLogin() {
    eventBus.addEventFilter(loginFilter);
  }

  @EventHandler
  public void onGotoLogin() {
    eventBus.removeEventFilter(loginFilter);
  }

  @EventHandler
  public void onNoValidLogin() {
    alert("User is not logged in!\nplease log in again!");
    eventBus.gotoLogin();
  }
}
