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

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import de.gishmo.gwt.example.mvp4g2.mail.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;
import de.gishmo.gwt.mvp4g2.core.eventbus.PresenterRegistration;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;

import java.util.HashMap;
import java.util.Map;

/**
 * this class manages the presenters of the emails displayed inside the content area.
 *
 * each time an email is added to the content area, a new presenter view pair is
 * created. Once we create a presenter by adding an instance to the event bus,
 * we receive a presnter registration to remove the presenter.
 */
@Handler
public class DetailHandler
  extends AbstractHandler<Mvp4g2MailEventBus> {

  /* map of presenter registration (id of the mail, presenter registration */
  private Map<String, PresenterRegistration> presenterRegistrations;

  public DetailHandler() {
    this.presenterRegistrations = new HashMap<>();
  }

  /**
   * each time we double click an email in the list, the selectEmail(id) event is fired.
   *
   * To handle this event, we check:
   *
   * - is the mail already displayed? in this case we will bring this to to front
   *
   * - if not, we call the server to get the mail content, create an instance
   * of the mail presenter (Called DetailPresenter), add the instance to the eventBus,
   * save the registration and it to the content area.
   *
   * @param id of the email
   */
  @EventHandler
  public void onSelectEmail(String id) {
    if (this.presenterRegistrations.get(id) == null) {
      ClientContext.get()
                   .getMailService()
                   .getMail(id,
                            new AsyncCallback<Mail>() {
                              @Override
                              public void onFailure(Throwable throwable) {
                                Window.alert("Panic");
                              }

                              @Override
                              public void onSuccess(Mail mail) {
                                DetailPresenter presenter = new DetailPresenter();
                                presenterRegistrations.put(id,
                                                           eventBus.addHandler(presenter));
                                presenter.edit(mail);
                                eventBus.addContent(mail.getId(),
                                                    mail.getSubject(),
                                                    presenter.asWidget());
                              }
                            });
    } else {
      eventBus.showContent(id);
    }
  }

  @EventHandler
  public void onRemoveEmail(String id) {
    // execute registration
    this.presenterRegistrations.get(id)
                               .remove();
    // remove from map
    this.presenterRegistrations.remove(id);
  }
}
