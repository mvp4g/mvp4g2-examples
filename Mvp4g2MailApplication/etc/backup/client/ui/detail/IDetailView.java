package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import com.google.gwt.user.client.ui.IsWidget;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.mvp4g2.core.ui.IsLazyReverseView;


public interface IDetailView
  extends IsLazyReverseView<IDetailView.Presenter>,
          IsWidget {
  
  boolean isDirty();
  
  void setUpData(Person result);

  interface Presenter {

    void doRevert();

    void doUpdate(Person person);

  }
}
