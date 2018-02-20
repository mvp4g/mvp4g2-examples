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
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  private Viewport              viewport;
  private BorderLayoutContainer shell;
  private ContentPanel       northContainer;
  private ContentPanel       southContainer;
  private SimpleContainer       centerContainer;

  public ShellView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return this.viewport;
  }

  @Override
  public void setCenter(Widget widget) {
    if (this.centerContainer.getWidget() != null) {
      this.centerContainer.getWidget()
                         .removeFromParent();
    }
    this.centerContainer.setWidget(widget);
  }

  @Override
  public void setNorth(Widget widget) {
    if (this.northContainer.getWidget() != null) {
      this.northContainer.getWidget()
                         .removeFromParent();
    }
    this.northContainer.setWidget(widget);
  }

  @Override
  public void setSouth(Widget widget) {
    GWT.debugger();
    if (this.southContainer.getWidget() != null) {
      this.southContainer.getWidget()
                         .removeFromParent();
    }
    this.southContainer.setWidget(widget);
  }

  public void createView() {
    this.viewport = new Viewport();

    this.shell = new BorderLayoutContainer();
    viewport.add(this.shell);

    this.northContainer = createContentPanel();
    BorderLayoutContainer.BorderLayoutData bldNorth = new BorderLayoutContainer.BorderLayoutData(512);
    bldNorth.setCollapsible(true);
    bldNorth.setSplit(true);
    this.shell.setNorthWidget(this.northContainer,
                              bldNorth);

    this.southContainer = createContentPanel();
    BorderLayoutContainer.BorderLayoutData bldSouth = new BorderLayoutContainer.BorderLayoutData(36);
    this.shell.setSouthWidget(this.southContainer,
                              bldSouth);

    this.centerContainer = new SimpleContainer();
    this.shell.setCenterWidget(this.centerContainer);
  }

  private ContentPanel createContentPanel() {
    ContentPanel cp = new ContentPanel();
    cp.setHeaderVisible(false);
    return cp;
  }
}
