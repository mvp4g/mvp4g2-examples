package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.shell;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

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
public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  private Viewport shell;

  private BorderLayoutContainer container;

  private SimpleContainer header;

  private ContentPanel navigation;

  private SimpleContainer statusbar;

  private SimpleContainer content;

  private Widget widget;

  public ShellView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return shell;
  }

  @Override
  public void setContent(Widget widget) {
    if (this.widget != null) {
      this.widget.removeFromParent();
    }
    this.content.setWidget(widget);
    this.widget = widget;
  }

  @Override
  public void setNavigation(Widget widget) {
    if (this.navigation.getWidget() != null) {
      this.navigation.getWidget()
                     .removeFromParent();
    }
    this.navigation.setWidget(widget);
  }

  @Override
  public void setHeader(Widget widget) {
    if (this.header.getWidget() != null) {
      this.header.getWidget()
                 .removeFromParent();
    }
    this.header.setWidget(widget);
  }

  @Override
  public void setStatusbar(Widget widget) {
    if (this.statusbar.getWidget() != null) {
      this.statusbar.getWidget()
                    .removeFromParent();
    }
    this.statusbar.setWidget(widget);
  }

  @Override
  public void createView() {
    shell = new Viewport();
    shell.setSize("100%",
                  "100%");
    container = new BorderLayoutContainer();
    container.setSize("100%",
                      "100%");
    shell.add(container);
    header = new SimpleContainer();
    BorderLayoutContainer.BorderLayoutData northData = new BorderLayoutContainer.BorderLayoutData(64);
    container.setNorthWidget(header,
                             northData);
    statusbar = new SimpleContainer();
    BorderLayoutContainer.BorderLayoutData southData = new BorderLayoutContainer.BorderLayoutData(42);
    container.setSouthWidget(statusbar,
                             southData);
    navigation = new ContentPanel();
    navigation.setHeading(SafeHtmlUtils.fromTrustedString("Navigation"));
    navigation.setBodyStyle("padding: 12px;");
    BorderLayoutContainer.BorderLayoutData westData = new BorderLayoutContainer.BorderLayoutData(212);
    westData.setCollapsible(true);
    westData.setFloatable(true);
    westData.setMargins(new Margins(12,
                                    0,
                                    12,
                                    12));
    container.setWestWidget(navigation,
                            westData);
    content = new SimpleContainer();
    container.setWidget(content);
    container.setCenterWidget(content,
                              new MarginData(12));
  }
}
