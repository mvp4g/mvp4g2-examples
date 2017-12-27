package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.handler;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Handler;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;

@Handler
public class SimpleApplicationHandler01
  extends AbstractHandler<Mvp4g2SimpleApplicationEventBus> {

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
