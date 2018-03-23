package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import com.google.gwt.core.client.GWT;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventFilter;

public class Mvp4g2SimpleApplicationFilter02
  implements IsEventFilter<Mvp4g2SimpleApplicationEventBus> {

  @Override
  public boolean filterEvent(Mvp4g2SimpleApplicationEventBus eventBus,
                             String eventName,
                             Object... params) {
    GWT.log("executing filter 2");
    return true;
  }
}
