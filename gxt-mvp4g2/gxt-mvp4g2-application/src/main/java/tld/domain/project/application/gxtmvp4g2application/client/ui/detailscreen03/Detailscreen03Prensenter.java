package tld.domain.project.application.gxtmvp4g2application.client.ui.detailscreen03;

import com.github.mvp4g.mvp4g2.core.history.IsNavigationConfirmation;
import com.github.mvp4g.mvp4g2.core.history.NavigationEventCommand;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import com.google.gwt.user.client.Window;
import java.lang.Override;
import java.lang.String;
import tld.domain.project.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;

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
@Presenter(
    viewClass = Detailscreen03View.class,
    viewInterface = IDetailscreen03View.class
)
public class Detailscreen03Prensenter extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, IDetailscreen03View> implements IDetailscreen03View.Presenter, IsNavigationConfirmation {
  public Detailscreen03Prensenter() {
  }

  @Override
  public void onBeforeEvent(String eventName) {
    // This method will be call in case the presenter will handle a event and before the event handling
  }

  @EventHandler
  public void onGotoDetailscreen03() {
    eventBus.setContent(view.asWidget());
    eventBus.setNavigationConfirmation(this);
  }

  @Override
  public void confirm(NavigationEventCommand event) {
    if (view.isDirty()) {
      if (Window.confirm("Do you really want to cancel?")) {
        event.fireEvent();
      }
    } else {
      event.fireEvent();
    }
  }
}
