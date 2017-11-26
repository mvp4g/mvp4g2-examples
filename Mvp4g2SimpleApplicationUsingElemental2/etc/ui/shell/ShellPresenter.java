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

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.IsShell;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

@Presenter(viewClass = ShellView.class, viewInterface = IShellView.class)
public class ShellPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus,
                             IShellView>
  implements IShellView.Presenter,
             IsShell {

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

  public void onSetContent(Element element) {
    view.setCenter(element);
  }

  public void onSetNavigation(Element element) {
    view.setNavigation(element);
  }

  @Override
  public void setShell() {
    DomGlobal.document.appendChild(view.asElement());
  }

  public void onSetStatus(String status) {
    view.setStatus(status);
  }
}
