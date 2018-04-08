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

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventFilter;

public class LoginFilter
  implements IsEventFilter<Mvp4g2SimpleApplicationWithLoginEventBus> {
  @Override
  public boolean filterEvent(Mvp4g2SimpleApplicationWithLoginEventBus eventBus,
                             String eventName,
                             Object... params) {
    // we do not filter the logoff event!
    if ("gotoLogin".equals(eventName) ||
        "logoff".equals(eventName) ||
        "setStatus".equals(eventName) ||
        "noValidLogin".equals(eventName)) {
      return true;
    }
    if (ClientContext.get().isLoggedIn()) {
      return true;
    }
    // inform the user, that he is not logged in! (not for the logoff event!)
    if (!"logoff".equals(eventName)) {
      eventBus.noValidLogin();
    }
    return false;
  }
}
