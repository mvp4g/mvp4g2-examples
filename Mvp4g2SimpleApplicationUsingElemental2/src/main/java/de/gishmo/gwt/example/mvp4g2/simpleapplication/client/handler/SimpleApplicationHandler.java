package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import com.github.mvp4g.mvp4g2.core.ui.AbstractHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Handler;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

@Handler
public class SimpleApplicationHandler
  extends AbstractHandler<Mvp4g2SimpleApplicationEventBus> {


  public void onSetNavigation(Element element) {
    DomGlobal.window.alert("Navigation is set!");
  }
}
