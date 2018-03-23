package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;

import java.util.List;

public interface IListView
  extends IsLazyReverseView<IListView.Presenter> {

  Element asElement();

  void resetTable();

  void setData(List<Person> result);

  interface Presenter {

    void doUpdate(Person object);

  }
}
