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

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

public class DetailView
  extends LazyReverseView<IDetailView.Presenter>
  implements IDetailView,
             Editor<Mail> {

  /* fields */
  @Path("sender")
  TextField sender;
  @Path("email")
  TextField emailSender;
  private HTML         body;
  private ContentPanel container;
  private Driver       driver;

  public DetailView() {
    super();
  }

  @Override
  public Widget asWidget() {
    return this.container;
  }

  @Override
  public void createView() {
    this.container = new ContentPanel();
    this.container.setHeaderVisible(false);
    this.container.setBodyStyle("padding: 12px;");

    VerticalLayoutContainer vlc = new VerticalLayoutContainer();
    this.container.setWidget(vlc);

    FieldLabel fl01 = new FieldLabel();
    fl01.setText("Sender");
    sender = new TextField();
    sender.setReadOnly(true);
    fl01.setWidget(sender);
    vlc.add(fl01,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    FieldLabel fl02 = new FieldLabel();
    fl02.setText("Email sender");
    emailSender = new TextField();
    emailSender.setReadOnly(true);
    fl02.setWidget(emailSender);
    vlc.add(fl02,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    FieldLabel fl03 = new FieldLabel();
    fl03.setText("Text");
    VerticalLayoutContainer vlc01 = new VerticalLayoutContainer();
    vlc01.setScrollMode(ScrollSupport.ScrollMode.AUTOY);
    vlc01.setBorders(true);
    body = new HTML();
    vlc01.add(body,
              new VerticalLayoutContainer.VerticalLayoutData(1,
                                                             1));
    fl03.setWidget(vlc01);
    vlc.add(fl03,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           1));
  }

  @Override
  public void bind() {
    driver = GWT.create(Driver.class);
    driver.initialize(this);
  }

  @Override
  public void edit(Mail mail) {
    driver.edit(mail);
    body.setHTML(mail.getBody());
  }

  interface Driver
    extends SimpleBeanEditorDriver<Mail, DetailView> {
  }
}
