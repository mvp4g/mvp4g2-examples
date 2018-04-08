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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.shell;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;

import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.Node;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.footer;
import static org.jboss.gwt.elemento.core.Elements.header;
import static org.jboss.gwt.elemento.core.Elements.img;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.Elements.label;
import static org.jboss.gwt.elemento.core.Elements.p;
import static org.jboss.gwt.elemento.core.EventType.click;

public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  /* Login screen */
  private HTMLElement      login;
  private HTMLElement      headline;
  private HTMLInputElement userId;
  private HTMLInputElement password;
  private HTMLInputElement loginButton;

  /* Shell */
  private HTMLElement shell;
  private HTMLElement navigation;
  private HTMLElement content;
  private HTMLElement status;

  public ShellView() {
    super();
  }

  @Override
  public Element loginAsElement() {
    document.body.className = "loginBody";
    shell.remove();
    return login;
  }

  @Override
  public Element shellAsElement() {
    document.body.classList.remove("loginBody");
    headline.remove();
    login.remove();
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

    createLogin();
    createShell();
  }

  private void createLogin() {
    headline = div().css("pageFont01 headline")
                    .textContent("Please use 'admin' and 'password'")
                    .asElement();
    userId = input("text").css("formField",
                               "formFieldUserId")
                          .asElement();
    password = input("password").css("formField",
                                     "formFieldPassword")
                                .asElement();
    loginButton = input("image").attr("src",
                                      "/media/images/loginDark.png")
                                .attr("value",
                                      "login")
                                .css("submitButton")
                                .on(click,
                                    e -> getPresenter().doLogin(userId.value,
                                                                password.value))
                                .asElement();

    login = div().add(headline)
                 .add(div().css("containerOutter")
                           .add(div().css("containerMiddle")
                                     .add(div().css("containerInner",
                                                    "containerCenterIndividual")
                                               .add(div().add(p().css("headlineLogon")
                                                                 .textContent("Please login:"))
                                                         .add(p().add(div().css("arUserId")
                                                                           .textContent("UserId:"))
                                                                 .add(userId)
                                                                 .add(div().css("ruler"))
                                                                 .add(div().css("arPassword")
                                                                           .textContent("Password:"))
                                                                 .add(password)
                                                                 .add(loginButton))))))
                 .asElement();
  }

  private void createShell() {
    shell = div().css("shell")
                 .add(createNorth())
                 .add(createSouth())
                 .add(navigation = div().css("shellNavigation")
                                        .asElement())
                 .add(content = div().css("shellContent")
                                     .asElement())
                 .asElement();
  }

  private Element createNorth() {
    return header().css("shellHeader")
                   .add(img("media/images/Gwt-logo.png").css("shellHeaderImage"))
                   .asElement();
  }

  private Element createSouth() {
    return footer().css("shellFooter")
                   .add(div().add(div().css("shellFooterLeft")
                                       .add(label().css("shellFooterLabel")
                                                   .textContent("GWT Basic training")))
                             .add(div().css("shellFooterRight")
                                       .add(status = div().css("shellFooterStatus")
                                                          .asElement())))
                   .asElement();
  }
}
