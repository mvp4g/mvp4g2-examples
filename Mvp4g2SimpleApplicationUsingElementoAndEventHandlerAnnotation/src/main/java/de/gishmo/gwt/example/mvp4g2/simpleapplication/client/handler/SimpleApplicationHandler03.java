package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

/**
 * we use the handler to check weather the framework will be able to call
 * presenters and handlers for the same event.
 *
 * for any ecvnt we handle, we will use a alert to present a info message.
 */
@Handler
public class SimpleApplicationHandler03
  extends AbstractHandler<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus> {

  @EventHandler
  public void onSetNavigation(Element element) {
    DomGlobal.window.alert("SimpleApplicationHandler03: -> Navigation is set!");
  }

  @EventHandler
  public void onGotoDetail(long id) {
    DomGlobal.window.alert("SimpleApplicationHandler03: -> fire event 'gotoDetail' with key: >>" + id + "<<");
  }

  @EventHandler
  public void onGotoList(String searchName,
                         String searchOrt) {
    DomGlobal.window.alert("SimpleApplicationHandler03: -> fire event 'gotoList' with searchName: >>" + searchName + "<< and searchName >>" + searchName + "<<");
  }

  @EventHandler
  public void onGotoSearch(String searchName,
                           String searchOrt) {
    DomGlobal.window.alert("SimpleApplicationHandler03: -> fire event 'gotoSearch' with searchName: >>" + searchName + "<< and searchName >>" + searchName + "<<");
  }

}
