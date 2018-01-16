package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import com.google.gwt.core.client.GWT;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.LoginFilter;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationWithLoginEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;

import elemental2.dom.DomGlobal;

import static elemental2.dom.DomGlobal.alert;

@Handler
public class SimpleApplicationHandler02
  extends AbstractHandler<Mvp4g2SimpleApplicationWithLoginEventBus> {

  private LoginFilter loginFilter;

  public SimpleApplicationHandler02() {
    loginFilter = new LoginFilter();
  }

  @EventHandler
  public void onStart() {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> handling start event");
  }

  @EventHandler
  public void onLogin() {
    eventBus.addEventFilter(loginFilter);
  }

  @EventHandler
  public void onRemoveLoginFilter() {
    eventBus.removeEventFilter(loginFilter);
  }

  @EventHandler
  public void onNoValidLogin() {
    alert("User is not logged in!\nplease log in again!");
  }
}
