package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.mvp4g2.core.eventbus.IsEventFilter;

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
