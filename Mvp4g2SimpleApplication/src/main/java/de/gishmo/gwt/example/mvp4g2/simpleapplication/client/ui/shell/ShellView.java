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
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationStyleFactory;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ImageResources;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;

public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  private ResizeLayoutPanel shell;
  private DockLayoutPanel   panel;
  private ApplicationCss    style;
  private Label             status;
  private ResizeLayoutPanel footerPanel;

  private Widget widget;

  public ShellView() {
    super();
    this.style = ApplicationStyleFactory.get().getStyle();
  }

  @Override
  public Widget asWidget() {
    return shell;
  }

  @Override
  public void setCenter(Widget widget) {
    if (this.widget != null) {
      this.widget.removeFromParent();
    }
    panel.add(widget);
    this.widget = widget;
  }

  @Override
  public void setNavigation(Widget widget) {
    GWT.debugger();
    panel.addWest(widget, 212);
  }

  @Override
  public void setStatus(String status) {
    this.status.setText(status);
  }

//  public void onLoad() {
//    shell.onLoad();
//    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
//      @Override
//      public void execute() {
//        forceLayout();
//      }
//    });
//  }

  public void createView() {
    shell = new ResizeLayoutPanel();
    shell.setSize("100%", "100%");
    shell.addResizeHandler(new ResizeHandler() {
      @Override
      public void onResize(ResizeEvent event) {
        forceLayout();
      }
    });

    panel = new DockLayoutPanel(Style.Unit.PX);
    panel.setSize("100%", "100%");
    shell.add(panel);

    Widget header = createNorth();
    panel.addNorth(header, 128);

    Widget footer = createSouth();
    panel.addSouth(footer, 42);
  }

  private Widget createNorth() {
    FlowPanel panel = new FlowPanel();
    panel.addStyleName(style.headerPanel());

    Image image = new Image(ImageResources.INSTANCE.gwtLogo());
    image.addStyleName(style.header());
    panel.add(image);

    return panel;
  }

  private Widget createSouth() {
    footerPanel = new ResizeLayoutPanel();
    footerPanel.addStyleName(style.footerPanel());

    FlowPanel panel = new FlowPanel();
    footerPanel.add(panel);

    FlowPanel left = new FlowPanel();
    left.addStyleName(style.footerLeft());
    panel.add(left);

    FlowPanel right = new FlowPanel();
    right.addStyleName(style.footerRight());
    panel.add(right);

    Label label = new Label(ApplicationConstants.CONSTANTS.footerText());
    label.addStyleName(style.footerLabel());
    left.add(label);

    status = new Label("");
    status.addStyleName(style.footerStatus());
    right.add(status);

    return footerPanel;
  }

  private void forceLayout() {
    if (shell.isAttached()) {
      Widget parent = shell.getParent();
      if (parent != null) {
        int parentWidth = parent.getOffsetWidth();
        footerPanel.setWidth(Integer.toString(parentWidth) + "px");
      }
    }
  }
}
