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

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

public class ContentView
  extends LazyReverseView<IContentView.Presenter>
  implements IContentView {

  private PlainTabPanel container;

  private TabItemConfig defaultTabItem;
  private HTML          defaultTabItemContent;

  public ContentView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return this.container;
  }

//  @Override
//  public void edit(ArrayList<Mail> listOfEmails) {
//    this.store.clear();
//    this.store.addAll(listOfEmails);
//  }

  public void createView() {
    this.container = new PlainTabPanel();
    this.container.setTabScroll(true);

    this.defaultTabItem = new TabItemConfig("Sample Mail Application");

    this.defaultTabItemContent = new HTML("");

    this.container.add(this.defaultTabItemContent, this.defaultTabItem);
  }

//  private void createStore() {
//    store = new ListStore<>(mailProperties.key());
//    Comparator<Mail> comparatorSender = new Comparator<Mail>() {
//      @Override
//      public int compare(Mail o1,
//                         Mail o2) {
//        return o1.getSender()
//                 .compareTo(o2.getSender());
//      }
//    };
//    store.addSortInfo(new Store.StoreSortInfo<>(comparatorSender,
//                                                SortDir.ASC));
//  }
//
//  private void createGrid() {
//    ColumnConfig<Mail, String> ccSender = new ColumnConfig<>(mailProperties.sender(),
//                                                             256,
//                                                             "Sender");
//    ccSender.setFixed(true);
//    ColumnConfig<Mail, String> ccEmail = new ColumnConfig<>(mailProperties.email(),
//                                                            256,
//                                                            "E-Mail");
//    ccEmail.setFixed(true);
//    ColumnConfig<Mail, String> ccSubject = new ColumnConfig<>(mailProperties.subject(),
//                                                              512,
//                                                              "subject");
//    List<ColumnConfig<Mail, ?>> list = new ArrayList<>();
//    list.add(ccSender);
//    list.add(ccEmail);
//    list.add(ccSubject);
//    ColumnModel<Mail> cm = new ColumnModel<>(list);
//    grid = new Grid<>(store,
//                      cm);
//    grid.setSize("100%",
//                 "512px");
//    grid.getView()
//        .setStripeRows(true);
//    grid.setBorders(true);
//    grid.getView()
//        .setAutoExpandColumn(ccSubject);
//    grid.getView()
//        .setForceFit(true);
//  }
//
//  @Override
//  public void bind() {
//    grid.addRowClickHandler(rowClickEvent -> {
//      getPresenter().doSelectRow(store.get(rowClickEvent.getRowIndex())
//                                      .getId());
//    });
//  }
}
