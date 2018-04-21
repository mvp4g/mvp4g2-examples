package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.detail;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

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
public class DetailView
  extends LazyReverseView<IDetailView.Presenter>
  implements IDetailView {
  private SimpleContainer container;

  public DetailView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public boolean isDirty() {
    return true;
  }

  @Override
  public void createView() {
    container = new SimpleContainer();
    Label label = new Label("detail");
    label.getElement()
         .getStyle()
         .setMargin(12,
                    Style.Unit.PX);
    container.setWidget(label);
  }
}
