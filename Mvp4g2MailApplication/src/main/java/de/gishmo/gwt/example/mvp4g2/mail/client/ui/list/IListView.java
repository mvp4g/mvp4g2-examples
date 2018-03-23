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

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;
import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;

import java.util.ArrayList;

public interface IListView
  extends IsLazyReverseView<IListView.Presenter>,
          IsWidget {

  Widget asWidget();

  void edit(ArrayList<Mail> listOfEmails);

  interface Presenter {

    void doSelectRow(String id);

  }
}
