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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationMessages;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.PersonSearch;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

import java.util.List;

@Presenter(viewClass = ListView.class, viewInterface = IListView.class)
public class ListPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus, IListView>
  implements IListView.Presenter {

  public ListPresenter() {
    super();
  }

  @Override
  public void doUpdate(Person object) {
    eventBus.gotoDetail(object.getId());
  }

  public void onGotoList(String searchName,
                         String searchCity) {
    ClientContext.get()
                 .getPersonService()
                 .get(new PersonSearch(searchName,
                                       searchCity),
                      new AsyncCallback<List<Person>>() {
                        @Override
                        public void onFailure(Throwable caught) {
                          Window.alert("PANIC!!!");
                        }

                        @Override
                        public void onSuccess(List<Person> result) {
                          view.resetTable();
                          view.setData(result);
                          eventBus.setContent(view.asWidget());
                          if (result.size() == 0) {
                            eventBus.setStatus(ApplicationConstants.CONSTANTS.statusListZero());
                          } else if (result.size() == 1) {
                            eventBus.setStatus(ApplicationConstants.CONSTANTS.statusListOne());
                          } else {
                            eventBus.setStatus(ApplicationMessages.MESSAGES.statusListMany(result.size()));
                          }
                        }
                      });
  }
}
