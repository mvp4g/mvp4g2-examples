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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.shell;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.core.ui.IsShell;
import de.gishmo.gwt.mvp4g2.core.ui.IsViewCreator;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = ShellView.class, viewInterface = IShellView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class ShellPresenter
  extends AbstractPresenter<Mvp4g2MailEventBus,
                             IShellView>
  implements IShellView.Presenter,
             IsViewCreator<IShellView>,
             IsShell<Mvp4g2MailEventBus,
                      IShellView> {

  public ShellPresenter() {
  }

  @Override
  public void setShell() {
    // add the shell to the browser viewport
    RootPanel.get().add(view.asWidget());
  }

  @EventHandler
  public void onSetNorth(Widget widget) {
    view.setNorth(widget);
  }

  @EventHandler
  public void onSetCenter(Widget widget) {
    view.setCenter(widget);
  }

  @EventHandler
  public void onSetSouth(Widget widget) {
    view.setSouth(widget);
  }

  public IShellView createView() {
    return GWT.create(ShellView.class);
  }
}
