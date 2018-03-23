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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.shell;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationWithLoginEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.IsShell;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import elemental2.dom.Element;

import static elemental2.dom.DomGlobal.alert;
import static elemental2.dom.DomGlobal.document;

@Presenter(viewClass = ShellView.class, viewInterface = IShellView.class)
public class ShellPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationWithLoginEventBus, IShellView>
  implements IShellView.Presenter,
             IsShell<Mvp4g2SimpleApplicationWithLoginEventBus, IShellView> {

  //  public void bind() {
  //    Element loadingIndicator = DOM.getElementById("loading");
  //    if (loadingIndicator != null) {
  //      loadingIndicator.removeFromParent();
  //    }
  //  }

  public ShellPresenter() {
  }

  public void onBeforeEvent(String eventName) {
  }

  @EventHandler
  public void onSetContent(Element element) {
    view.setCenter(element);
  }

  @EventHandler
  public void onSetNavigation(Element element) {
    view.setNavigation(element);
  }

  @Override
  public void setShell() {
    document.body.appendChild(view.loginAsElement());
  }

  @EventHandler
  public void onSetStatus(String status) {
    view.setStatus(status);
  }

  @EventHandler
  public void onGotoLogin() {
    document.body.appendChild(view.loginAsElement());
  }

  @Override
  public void doLogin(String userId,
                      String password) {
    if (!"admin".equals(userId) || !"password".equals(password)) {
      alert("login data not valid");
    } else {
      ClientContext.get()
                   .setLoggedIn(true);

      document.body.appendChild(view.shellAsElement());
      eventBus.login();
      eventBus.setUpShell();
      eventBus.gotoSearch("",
                          "");
    }
  }
}
