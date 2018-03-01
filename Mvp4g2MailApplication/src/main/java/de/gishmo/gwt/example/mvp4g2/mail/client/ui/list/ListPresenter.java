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

package de.gishmo.gwt.example.mvp4g2.mail.client.ui.list;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gishmo.gwt.example.mvp4g2.mail.client.Mvp4g2MailEventBus;
import de.gishmo.gwt.example.mvp4g2.mail.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.core.ui.IsViewCreator;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Presenter;

import java.util.ArrayList;

@Presenter(viewClass = ListView.class, viewInterface = IListView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class ListPresenter
  extends AbstractPresenter<Mvp4g2MailEventBus,
                             IListView>
  implements IListView.Presenter,
             IsViewCreator<IListView> {

  public ListPresenter() {
  }

  public void bind() {
    eventBus.setNorth(view.asWidget());
  }

  @EventHandler
  public void onStartApplication() {
    ClientContext.get().getMailService().getAllMails(new AsyncCallback<ArrayList<Mail>>() {
      @Override
      public void onFailure(Throwable throwable) {
        Window.alert("panic!");
      }

      @Override
      public void onSuccess(ArrayList<Mail> listOfEmails) {
        view.edit(listOfEmails);
        eventBus.updateStatus("Found: " + Integer.toString(listOfEmails.size()) + " emails");
      }
    });
  }

  @Override
  public IListView createView() {
    return new ListView();
  }

  @Override
  public void doSelectRow(String id) {

  }
}
