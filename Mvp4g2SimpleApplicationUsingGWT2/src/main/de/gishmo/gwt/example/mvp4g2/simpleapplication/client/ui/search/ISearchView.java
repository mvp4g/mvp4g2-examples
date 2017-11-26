package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import com.google.gwt.user.client.ui.IsWidget;
import de.gishmo.gwt.mvp4g2.client.ui.IsLazyReverseView;

public interface ISearchView
  extends IsLazyReverseView<ISearchView.Presenter>,
          IsWidget {
  
  void setSearch(String searchName,
                 String searchCity);

  interface Presenter {

    void doClickSearchButton(String searchName,
                             String searchCity);

  }
}
