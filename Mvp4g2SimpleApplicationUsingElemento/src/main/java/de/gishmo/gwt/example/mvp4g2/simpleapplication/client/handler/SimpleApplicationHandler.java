package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractEventHandler;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.EventHandler;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

@EventHandler
public class SimpleApplicationHandler
  extends AbstractEventHandler<Mvp4g2SimpleApplicationEventBus> {


  public void onSetNavigation(Element element) {
    DomGlobal.window.alert("Navigation is set!");
  }
}
