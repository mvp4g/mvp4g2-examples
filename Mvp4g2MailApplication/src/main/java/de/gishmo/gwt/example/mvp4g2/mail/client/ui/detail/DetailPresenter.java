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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.detail;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = DetailView.class, viewInterface = IDetailView.class, multiple = true)
public class DetailPresenter
  extends AbstractPresenter<Mvp4g2MailEventBus,
                             IDetailView>
  implements IDetailView.Presenter {

  private String mailId;

  public DetailPresenter() {
  }

  public void edit(Mail mail) {
    view.edit(mail);
  }

  @Override
  public Widget asWidget() {
    return view.asWidget();
  }
}
