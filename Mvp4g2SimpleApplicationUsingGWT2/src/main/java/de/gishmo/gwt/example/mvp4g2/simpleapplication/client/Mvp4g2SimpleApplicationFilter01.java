package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.mvp4g2.client.eventbus.IsEventFilter;

public class Mvp4g2SimpleApplicationFilter01
  implements IsEventFilter<Mvp4g2SimpleApplicationEventBus> {

  @Override
  public boolean filterEvent(Mvp4g2SimpleApplicationEventBus eventBus,
                             String eventName,
                             Object... params) {
    GWT.log("executing filter 1");
    return true;
  }
}
