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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.navigation;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.AbstractSimpleApplicationPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;

@Presenter(viewClass = NavigationView.class, viewInterface = INavigationView.class)
public class NavigationPresenter
  extends AbstractSimpleApplicationPresenter<Mvp4g2SimpleApplicationEventBus, INavigationView>
  implements INavigationView.Presenter {

  public NavigationPresenter() {
  }

  public Widget asWidget() {
    return view.asWidget();
  }

  @Override
  public void bind() {
    eventBus.setNavigation(view.asWidget());
  }

  @Override
  public void doShowList() {
    if (ClientContext.get()
                     .getPersonSearch() != null) {
      eventBus.gotoList(ClientContext.get()
                                     .getPersonSearch()
                                     .getName(),
                        ClientContext.get()
                                     .getPersonSearch()
                                     .getCity());
    } else {
      eventBus.gotoSearch("",
                          "");
    }
  }

  @Override
  public void doShowSearch() {
    eventBus.gotoSearch(ClientContext.get()
                                     .getPersonSearch()
                                     .getName(),
                        ClientContext.get()
                                     .getPersonSearch()
                                     .getCity());
  }
}
