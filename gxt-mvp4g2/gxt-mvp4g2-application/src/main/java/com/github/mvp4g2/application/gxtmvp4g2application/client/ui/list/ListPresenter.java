package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.list;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.domain.dto.shared.search.PersonSearch;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import com.github.mvp4g2.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.List;

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
@Presenter(viewClass = ListView.class,
           viewInterface = IListView.class)
public class ListPresenter
    extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, IListView>
    implements IListView.Presenter {
  public ListPresenter() {
  }

  @Override
  public void onBeforeEvent(String eventName) {
    // This method will be call in case the presenter will handle a event and before the event handling
  }

  @EventHandler
  public void onGotoList(String searchName,
                         String searchCity) {
    Services.get()
            .getPersonService()
            .search(new PersonSearch(searchName,
                                     searchCity),
                    new MethodCallback<List<Person>>() {
                      @Override
                      public void onFailure(Method method,
                                            Throwable throwable) {
                        Window.alert("Panic!");
                      }

                      @Override
                      public void onSuccess(Method method,
                                            List<Person> list) {
                        view.edit(list);
                        if (list.size() == 0) {
                          eventBus.setStatusMessage("No persons found!");
                        } else if (list.size() == 1) {
                          eventBus.setStatusMessage("One persons found!");
                        } else {
                          eventBus.setStatusMessage(list.size() + " persons found!");
                        }
                      }
                    });
    eventBus.setContent(view.asWidget());
  }

  @Override
  public void doEdit(Person selectedItem) {
    eventBus.showPerson(selectedItem.getId());
  }

  @Override
  public void doNew() {
    eventBus.newPerson();
  }
}
