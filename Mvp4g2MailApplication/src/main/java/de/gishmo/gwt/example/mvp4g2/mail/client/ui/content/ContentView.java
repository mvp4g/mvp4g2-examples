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
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.PlainTabPanel;
import com.sencha.gxt.widget.core.client.TabItemConfig;
import com.sencha.gxt.widget.core.client.event.CloseEvent;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;

import java.util.HashMap;
import java.util.Map;

public class ContentView
  extends LazyReverseView<IContentView.Presenter>
  implements IContentView {

  private ContentPanel  container;
  private PlainTabPanel tabPanel;

  private TabItemConfig defaultTabItem;
  private HTML          defaultTabItemContent;

  private Map<String, Widget> openEmails;

  public ContentView() {
    super();
    this.openEmails = new HashMap<>();
  }

  @Override
  public Widget asWidget() {
    return this.tabPanel;
  }

  @Override
  public void bind() {
    this.tabPanel.addCloseHandler(new CloseEvent.CloseHandler<Widget>() {
      @Override
      public void onClose(CloseEvent<Widget> event) {
        for (String key : openEmails.keySet()) {
          if (event.getItem()
                   .equals(openEmails.get(key))) {
            openEmails.remove(key);
            getPresenter().doRemoveMail(key);
            return;
          }
        }
      }
    });
  }

  @Override
  public void createView() {
    this.container = new ContentPanel();
    this.container.setHeaderVisible(false);

    this.tabPanel = new PlainTabPanel();
    this.container.setWidget(this.tabPanel);
    this.tabPanel.setTabScroll(true);

    this.defaultTabItem = new TabItemConfig("Sample Mail Application");

    this.defaultTabItemContent = new HTML("");

    this.tabPanel.add(this.defaultTabItemContent,
                      this.defaultTabItem);
  }

  @Override
  public void addContent(String id,
                         String subject,
                         Widget widget) {
    if (this.openEmails.get(id) == null) {
      TabItemConfig tabItemConfig = new TabItemConfig(subject);
      tabItemConfig.setClosable(true);
      this.tabPanel.add(widget,
                        tabItemConfig);
      this.openEmails.put(id,
                          widget);
    }
    showContent(id);
    container.forceLayout();
  }

  @Override
  public void showContent(String id) {
    this.tabPanel.setActiveWidget(this.openEmails.get(id));
    container.forceLayout();
  }
}
