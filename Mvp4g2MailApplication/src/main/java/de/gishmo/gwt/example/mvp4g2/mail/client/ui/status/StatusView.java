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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.status;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

public class StatusView
  extends LazyReverseView<IStatusView.Presenter>
  implements IStatusView {

  private static ThemeDetails themeDetails = GWT.create(ThemeDetails.class);

  private SimpleContainer container;
  private Label           label;

  public StatusView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return this.container;
  }

  public void createView() {
    this.container = new SimpleContainer();

    this.label = new Label("loading ...");
    this.label.getElement()
              .getStyle()
              .setProperty("fontSize",
                           "24px");
    this.label.getElement()
              .getStyle()
              .setProperty("fontFamily",
                           themeDetails.panel()
                                       .font()
                                       .family());
    this.label.getElement()
              .getStyle()
              .setProperty("color",
                           themeDetails.borderColor());

    this.container.add(this.label,
                       new MarginData(6));
  }
}
