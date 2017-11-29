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

  public void createView() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    shell = (HTMLDivElement) document.createElement("div");
    shell.style.height = CSSProperties.HeightUnionType.of("auto");
    shell.style.width = CSSProperties.WidthUnionType.of("100%");
    shell.style.margin = CSSProperties.MarginUnionType.of(0);

    Element header = createNorth();
    shell.appendChild(header);

    navigation = (HTMLDivElement) document.createElement("div");
    navigation.style.position = "absolute";
    navigation.style.overflow = "hidden";
    navigation.style.top = "128px";
    navigation.style.bottom = "42px";
    navigation.style.left = String.valueOf(0);
    navigation.style.width = CSSProperties.WidthUnionType.of("212px");
    navigation.style.borderRight = "black 1px solid";
    shell.appendChild(navigation);

    content = (HTMLDivElement) document.createElement("div");
    content.style.position = "absolute";
    content.style.overflow = "hidden";
    content.style.top = "128px";
    content.style.bottom = "42px";
    content.style.left = "212px";
    content.style.right = String.valueOf(0);

    shell.appendChild(content);

    Element footer = createSouth();
    shell.appendChild(footer);
  }

  private Element createNorth() {
    HTMLElement panel = (HTMLElement) document.createElement("header");
    panel.style.position = "absolute";
    panel.style.overflow = "hidden";
    panel.style.height = CSSProperties.HeightUnionType.of("128px");
    panel.style.top = String.valueOf(0);
    panel.style.right = String.valueOf(0);
    panel.style.left = String.valueOf(0);
    panel.style.width = CSSProperties.WidthUnionType.of("100%");
    panel.style.borderBottom = "black 1px solid";

    HTMLImageElement image = (HTMLImageElement) document.createElement("img");
    image.style.margin = CSSProperties.MarginUnionType.of("12px");
    image.src = "media/images/Gwt-logo.png";
    panel.appendChild(image);

    return panel;
  }

  private Element createSouth() {
    footerPanel = (HTMLDivElement) document.createElement("div");
    footerPanel.style.position = "absolute";
    footerPanel.style.overflow = "hidden";
    footerPanel.style.height = CSSProperties.HeightUnionType.of("42px");
    footerPanel.style.bottom = String.valueOf(0);
    footerPanel.style.right = String.valueOf(0);
    footerPanel.style.left = String.valueOf(0);
    footerPanel.style.width = CSSProperties.WidthUnionType.of("100%");
    footerPanel.style.borderTop = "black 1px solid";

    HTMLDivElement panel = (HTMLDivElement) document.createElement("div");
    footerPanel.appendChild(panel);

    HTMLDivElement left = (HTMLDivElement) document.createElement("div");
    left.style.cssFloat = "left";
    left.style.padding = CSSProperties.PaddingUnionType.of("12px");
    panel.appendChild(left);

    HTMLDivElement right = (HTMLDivElement) document.createElement("div");
    right.style.textAlign = "right";
    right.style.padding = CSSProperties.PaddingUnionType.of("12px");
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
}
