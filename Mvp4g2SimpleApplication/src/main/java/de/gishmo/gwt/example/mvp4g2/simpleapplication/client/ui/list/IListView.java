package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import com.google.gwt.user.client.ui.IsWidget;
import de.gishmo.gwt.example.module0503.shared.dto.Person;
import de.gishmo.gwt.mvp4g2.client.ui.IsLazyReverseView;

import java.util.List;

public interface IListView
  extends IsLazyReverseView<IListView.Presenter>,
          IsWidget {
  
  void resetTable();
  
  void setData(List<Person> result);

  public interface Presenter {

    void doUpdate(Person object);

  }
}
