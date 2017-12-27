package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;
import elemental2.dom.DomGlobal;

@Handler
public class SimpleApplicationHandler02
  extends AbstractHandler<Mvp4g2SimpleApplicationEventBus> {

  public void onStart() {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> handling start event");
  }

}
