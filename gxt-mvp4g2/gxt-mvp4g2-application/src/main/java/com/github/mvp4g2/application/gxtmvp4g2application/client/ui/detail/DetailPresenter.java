package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.detail;

import com.github.mvp4g.domain.dto.shared.model.Person;
import com.github.mvp4g.mvp4g2.core.history.IsNavigationConfirmation;
import com.github.mvp4g.mvp4g2.core.history.NavigationEventCommand;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import com.github.mvp4g2.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;
import com.github.mvp4g2.application.gxtmvp4g2application.client.model.ClientContext;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.Services;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

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
@Presenter(viewClass = DetailView.class,
           viewInterface = IDetailView.class)
public class DetailPresenter
    extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, IDetailView>
    implements IDetailView.Presenter,
               IsNavigationConfirmation {

  private boolean isNew;
  private boolean isUpdated;

  private Person person;

  public DetailPresenter() {
  }

  @Override
  public void onBeforeEvent(String eventName) {
    // This method will be call in case the presenter will handle a event and before the event handling
  }

  @EventHandler
  public void onNewPerson() {
    isUpdated = false;
    eventBus.setNavigationConfirmation(this);
    this.isNew = true;
    this.person = new Person();
    view.edit(person,
              isNew);
    eventBus.setContent(view.asWidget());
    eventBus.setStatusMessage("Please enter the details of the new person");
  }

  @EventHandler
  public void onShowPerson(long id) {
    isUpdated = false;
    eventBus.setNavigationConfirmation(this);
    eventBus.setContent(view.asWidget());
    this.isNew = false;
    Services.get()
            .getPersonService()
            .get(Long.toString(id),
                 new MethodCallback<Person>() {
                   @Override
                   public void onFailure(Method method,
                                         Throwable throwable) {
                     Window.alert("Panic!");
                   }

                   @Override
                   public void onSuccess(Method method,
                                         Person personFromCall) {
                     person = personFromCall;
                     view.edit(person,
                               isNew);
                     eventBus.setStatusMessage("Please update the person data.");
                   }
                 });
  }

  @Override
  public void confirm(NavigationEventCommand event) {
    if (view.isDirty()) {
      if (!isUpdated) {
        if (Window.confirm("Do you really want to cancel?")) {
          event.fireEvent();
        }
      } else {
        event.fireEvent();
      }
    } else {
      event.fireEvent();
    }
  }

  @Override
  public void doSave(Person flush) {
    isUpdated = true;
    if (isNew) {
      Services.get()
              .getPersonService()
              .insert(person,
                      new MethodCallback<Void>() {
                        @Override
                        public void onFailure(Method method,
                                              Throwable throwable) {
                          Window.alert("Panic!");
                        }

                        @Override
                        public void onSuccess(Method method,
                                              Void result) {
                          eventBus.gotoList(ClientContext.get()
                                                         .getPersonSearch()
                                                         .getName(),
                                            ClientContext.get()
                                                         .getPersonSearch()
                                                         .getCity());
                        }
                      });
    } else {
      Services.get()
              .getPersonService()
              .update(person,
                      new MethodCallback<Void>() {
                        @Override
                        public void onFailure(Method method,
                                              Throwable throwable) {
                          Window.alert("Panic!");
                        }

                        @Override
                        public void onSuccess(Method method,
                                              Void result) {
                          eventBus.gotoList(ClientContext.get()
                                                         .getPersonSearch()
                                                         .getName(),
                                            ClientContext.get()
                                                         .getPersonSearch()
                                                         .getCity());
                        }
                      });
    }
  }

  @Override
  public void doCancel() {
    eventBus.gotoList(ClientContext.get()
                                   .getPersonSearch()
                                   .getName(),
                      ClientContext.get()
                                   .getPersonSearch()
                                   .getCity());
  }
}
