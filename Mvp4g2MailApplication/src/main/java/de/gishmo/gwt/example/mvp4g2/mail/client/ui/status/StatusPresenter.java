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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.status;

import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = StatusView.class, viewInterface = IStatusView.class)
public class StatusPresenter
  extends AbstractPresenter<Mvp4g2MailEventBus,
                             IStatusView>
  implements IStatusView.Presenter {

  public StatusPresenter() {
  }

  public void bind() {
    eventBus.setSouth(view.asWidget());
  }

  @EventHandler
  public void onUpdateStatus(String status) {
    view.setStatus(status);
  }

}
