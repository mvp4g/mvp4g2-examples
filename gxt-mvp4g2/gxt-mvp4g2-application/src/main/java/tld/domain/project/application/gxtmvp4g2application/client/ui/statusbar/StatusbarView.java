package tld.domain.project.application.gxtmvp4g2application.client.ui.statusbar;

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import java.lang.Override;

/**
 * Copyright (C) 2018 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class StatusbarView extends LazyReverseView<IStatusbarView.Presenter> implements IStatusbarView {
  private SimpleContainer container;

  public StatusbarView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return container;
  }

  @Override
  public void createView() {
    container = new SimpleContainer();
    Label label = new Label("That's the footer area. Create your footer here");
    label.getElement().getStyle().setMargin(12, Style.Unit.PX);
    container.setWidget(label);
  }
}
