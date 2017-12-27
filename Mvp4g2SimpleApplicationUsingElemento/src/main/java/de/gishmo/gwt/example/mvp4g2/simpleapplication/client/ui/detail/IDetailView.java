package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;


public interface IDetailView
  extends IsLazyReverseView<IDetailView.Presenter> {

  Element asElement();

  boolean isDirty();

  void setUpData(Person result);

  interface Presenter {

    void doRevert();

    void doUpdate(Person person);

  }
}
