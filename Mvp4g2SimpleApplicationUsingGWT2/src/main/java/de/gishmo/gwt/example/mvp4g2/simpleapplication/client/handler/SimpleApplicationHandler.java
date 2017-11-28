package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractEventHandler;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.EventHandler;

@EventHandler
public class SimpleApplicationHandler
  extends AbstractEventHandler<Mvp4g2SimpleApplicationEventBus> {


  public void onSetNavigation(Widget widget) {
    Window.alert("Navigation is set!");
  }
}
