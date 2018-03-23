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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.content;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = ContentView.class, viewInterface = IContentView.class)
public class ContentPresenter
  extends AbstractPresenter<Mvp4g2MailEventBus,
                             IContentView>
  implements IContentView.Presenter {

  public ContentPresenter() {
  }

  public void bind() {
    eventBus.setCenter(view.asWidget());
  }

  @EventHandler
  public void onAddContent(String id,
                           String subject,
                           Widget widget) {
    view.addContent(id,
                    subject,
                    widget);
  }

  @EventHandler
  public void onShowContent(String id) {
    view.showContent(id);
  }

  @Override
  public void doRemoveMail(String id) {
    eventBus.removeEmail(id);
  }
}
