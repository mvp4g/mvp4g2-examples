package de.gishmo.gwt.example.mvp4g2.springboot.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;


public interface IDetailView
  extends IsLazyReverseView<IDetailView.Presenter> {

  /**
   * mvp4g2 does not know Widget-, Element- or any other class. So, the
   * presenter have to manage the widget by themselves. The method will
   * enable the presenter to get the view. (In our case it is a
   * Elemental 2 element!)
   *
   * @return The detail element
   */
  Element asElement();

  /**
   * Will tell the presenter weather there is a input or not
   *
   * @return true -> the user enters data
   */
  boolean isDirty();

  void setUpData(Person result);

  interface Presenter {

    void doRevert();

    void doUpdate(Person person);

  }
}
