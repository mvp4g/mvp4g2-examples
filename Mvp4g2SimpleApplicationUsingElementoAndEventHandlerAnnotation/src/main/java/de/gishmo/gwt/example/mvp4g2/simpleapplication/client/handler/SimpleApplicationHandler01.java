package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Handler;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

@Handler
public class SimpleApplicationHandler01
  extends AbstractHandler<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus> {

  @EventHandler
  public void onSetNavigation(Element element) {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> Navigation is set!");
  }

  @EventHandler
  public void onGotoDetail(long id) {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> fire event 'gotoDetail' with key: >>" + id + "<<");
  }

  @EventHandler
  public void onGotoList(String searchName,
                         String searchOrt) {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> fire event 'gotoList' with searchName: >>" + searchName + "<< and searchName >>" + searchName + "<<");
  }

  @EventHandler
  public void onGotoSearch(String searchName,
                           String searchOrt) {
    DomGlobal.window.alert("SimpleApplicaitonHandler02: -> fire event 'gotoSearch' with searchName: >>" + searchName + "<< and searchName >>" + searchName + "<<");
  }

}
