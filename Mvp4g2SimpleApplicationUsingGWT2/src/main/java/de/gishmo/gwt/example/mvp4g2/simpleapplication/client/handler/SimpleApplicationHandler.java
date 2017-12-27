package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;

@Handler
public class SimpleApplicationHandler
  extends AbstractHandler<Mvp4g2SimpleApplicationEventBus> {

  public void onStart() {
    Window.alert("SimpleApplicaitonHandler handels >>onStart<<");
  }

  public void onSetNavigation(Widget widget) {
    Window.alert("SimpleApplicaitonHandler handels >>onSetNavigation<<");

  }
}
