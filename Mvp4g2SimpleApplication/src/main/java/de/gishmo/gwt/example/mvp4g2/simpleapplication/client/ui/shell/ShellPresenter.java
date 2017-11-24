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

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.IsShell;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;

@Presenter(viewClass = ShellView.class, viewInterface = IShellView.class)
public class ShellPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus,
                             IShellView>
  implements IShellView.Presenter,
             IsShell {
//
//  @SuppressWarnings("unused")
//  @Inject
//  private ClientContext clientContext;
//
//  public void bind() {
//    Element loadingIndicator = DOM.getElementById("loading");
//    if (loadingIndicator != null) {
//      loadingIndicator.removeFromParent();
//    }
//  }

  public ShellPresenter() {
  }

  public void onBeforeEvent(String eventName) {
    GWT.log("onBefore for event -> " + eventName);
  }

  public void onSetContent(Widget widget) {
    view.setCenter(widget);
  }

  public void onSetNavigation(Widget widget) {
    view.setNavigation(widget);
  }

  @Override
  public void setShell() {
    RootLayoutPanel.get()
                   .add(view.asWidget());
  }

  public void onStart() {
    GWT.debugger();
    // TODO remove this, once History is implemented
    eventBus.gotoSearch("", "");
  }

  public void onSetStatus(String status) {
    view.setStatus(status);
  }
}
