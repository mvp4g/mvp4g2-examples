package tld.domain.project.application.gxtmvp4g2application.client.ui.header;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
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
public class HeaderView
  extends LazyReverseView<IHeaderView.Presenter>
  implements IHeaderView {

  private static ThemeDetails    themeDetails = GWT.create(ThemeDetails.class);
  private        SimpleContainer container;

  public HeaderView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void createView() {
    container = new SimpleContainer();
    container.getElement()
             .getStyle()
             .setBackgroundColor("#283A48");
    container.setSize("100%",
                      "100%");
    Label label = new Label("Sencha GXT + MVP4G2 example application");
    label.getElement()
         .getStyle()
         .setProperty("marginTop",
                      "30px");
    label.getElement()
         .getStyle()
         .setProperty("marginLeft",
                      "16px");
    label.getElement()
         .getStyle()
         .setProperty("fontSize",
                      "24px");
    label.getElement()
         .getStyle()
         .setProperty("fontFamily",
                      themeDetails.panel()
                                  .font()
                                  .family());
    label.getElement()
         .getStyle()
         .setProperty("fontWeight",
                      "bold");
    label.getElement()
         .getStyle()
         .setProperty("color",
                      themeDetails.panel()
                                  .font()
                                  .color());

    container.setWidget(label);
  }
}
