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

import de.gishmo.gwt.mvp4g2.client.ui.IsLazyReverseView;
import elemental2.dom.Element;

public interface IShellView
  extends IsLazyReverseView<IShellView.Presenter> {

  Element asElement();

  void setCenter(Element asWidget);

  void setNavigation(Element widget);

  void setStatus(String status);

  interface Presenter {

  }
}
