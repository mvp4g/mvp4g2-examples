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

import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;
import elemental2.dom.*;
import jsinterop.base.Js;

import static elemental2.dom.DomGlobal.document;

public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  private HTMLDivElement shell;
  private HTMLDivElement navigation;
  private HTMLDivElement content;
  private HTMLDivElement status;


  private HTMLDivElement footerPanel;

  public ShellView() {
    super();
  }

  @Override
  public Element asElement() {
    return shell;
  }

  @Override
  public void setCenter(Element element) {
    Js.debugger();
    if (content.childElementCount > 0) {
      for (int i = 0; i < content.childNodes.length; i++) {
        Node oldChild = content.childNodes.item(i);
        content.removeChild(oldChild);
      }
    }
    content.appendChild(element);
  }

  @Override
  public void setNavigation(Element element) {
    navigation.appendChild(element);
  }

  @Override
  public void setStatus(String status) {
    this.status.innerHTML = status;
  }

////  public void onLoad() {
////    shell.onLoad();
////    Scheduler.get().scheduleDeferred(new ScheduledCommand() {
////      @Override
////      public void execute() {
////        forceLayout();
////      }
////    });
////  }

  public void createView() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    shell = (HTMLDivElement) document.createElement("div");
    shell.style.height = CSSProperties.HeightUnionType.of("auto");
    shell.style.width = CSSProperties.WidthUnionType.of("100%");
    shell.style.margin = CSSProperties.MarginUnionType.of(0);
//    shell.addResizeHandler(new ResizeHandler() {
//      @Override
//      public void onResize(ResizeEvent event) {
//        forceLayout();
//      }
//    });


    Element header = createNorth();
    shell.appendChild(header);

    navigation = (HTMLDivElement) document.createElement("div");
    navigation.style.overflow = "hidden";
    navigation.style.width = CSSProperties.WidthUnionType.of("100%");
    navigation.className = "navigationPanel";
    shell.appendChild(navigation);

    content = (HTMLDivElement) document.createElement("div");
//    content.style.position = "absolute";
    content.style.overflow = "hidden";
    content.style.width = CSSProperties.WidthUnionType.of("100%");
    content.style.cssFloat = "left";
    shell.appendChild(content);

    Element footer = createSouth();
    shell.appendChild(footer);
  }

  private Element createNorth() {
    HTMLElement panel = (HTMLElement) document.createElement("header");
    panel.style.height = CSSProperties.HeightUnionType.of("128px");
    panel.style.width = CSSProperties.WidthUnionType.of("100%");
    panel.className = "headerPanel";

    HTMLImageElement image = (HTMLImageElement) document.createElement("img");
    image.className = "header";
    image.src = "media/images/Gwt-logo.png";
    panel.appendChild(image);

    return panel;
  }

  private Element createSouth() {
    footerPanel = (HTMLDivElement) document.createElement("div");
    footerPanel.style.position = "absolute";
    footerPanel.style.overflow = "hidden";
    footerPanel.style.right = String.valueOf(0);
    footerPanel.style.left = String.valueOf(0);
    footerPanel.style.bottom = String.valueOf(0);
    footerPanel.style.height = CSSProperties.HeightUnionType.of("42px");
    footerPanel.style.width = CSSProperties.WidthUnionType.of("100%");

    HTMLDivElement panel = (HTMLDivElement) document.createElement("div");
    panel.style.height = CSSProperties.HeightUnionType.of("42px");
    panel.style.width = CSSProperties.WidthUnionType.of("100%");
    panel.className = "footerPanel";
    footerPanel.appendChild(panel);

    HTMLDivElement left = (HTMLDivElement) document.createElement("div");
    left.className = "footerLeft";
    panel.appendChild(left);

    HTMLDivElement right = (HTMLDivElement) document.createElement("div");
    right.className = "footerRight";
    panel.appendChild(right);

    HTMLDivElement label = (HTMLDivElement) document.createElement("div");
    label.className = "footerLabel";
    label.innerHTML = "GWT Basic Training";
    left.appendChild(label);

    status = (HTMLDivElement) document.createElement("div");
    status.className = "footerStatus";
    right.appendChild(status);

    return footerPanel;
  }

//  private void forceLayout() {
//    if (shell.isAttached()) {
//      Widget parent = shell.getParent();
//      if (parent != null) {
//        int parentWidth = parent.getOffsetWidth();
//        footerPanel.setWidth(Integer.toString(parentWidth) + "px");
//      }
//    }
//  }
}
