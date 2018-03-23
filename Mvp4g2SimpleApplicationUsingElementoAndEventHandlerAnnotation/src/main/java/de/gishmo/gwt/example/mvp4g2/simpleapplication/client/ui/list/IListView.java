package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;

import java.util.List;

public interface IListView
  extends IsLazyReverseView<IListView.Presenter> {

  /**
   * mvp4g2 does not know Widget-, Element- or any other class. So, the
   * presenter have to manage the widget by themselves. The method will
   * enable the presenter to get the view. (In our case it is a
   * Elemental 2 element!)
   *
   * @return The list element
   */
  Element asElement();

  void resetTable();

  void setData(List<Person> result);

  public interface Presenter {

    void doUpdate(Person object);

  }
}
