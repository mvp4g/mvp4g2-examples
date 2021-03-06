package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.shell;

import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.IsShell;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import com.github.mvp4g2.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

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
@Presenter(
  viewClass = ShellView.class,
  viewInterface = IShellView.class
)
public class ShellPresenter
  extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, IShellView>
  implements IShellView.Presenter,
             IsShell<GxtMvp4g2ApplicationEventBus, IShellView> {

  public ShellPresenter() {
  }

  public void onBeforeEvent(String eventName) {
  }

  @EventHandler
  public void onSetContent(Widget widget) {
    view.setContent(widget);
  }

  @EventHandler
  public void onSetHeader(Widget widget) {
    view.setHeader(widget);
  }

  @EventHandler
  public void onSetNavigation(Widget widget) {
    view.setNavigation(widget);
  }

  @EventHandler
  public void onSetStatusbar(Widget widget) {
    view.setStatusbar(widget);
  }

  @Override
  public void setShell() {
    RootLayoutPanel.get()
                   .add(view.asWidget());
  }
}
