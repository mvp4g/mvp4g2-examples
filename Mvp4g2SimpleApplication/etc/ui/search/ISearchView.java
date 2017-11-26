package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import de.gishmo.gwt.mvp4g2.client.ui.IsLazyReverseView;
import elemental2.dom.Element;

public interface ISearchView
  extends IsLazyReverseView<ISearchView.Presenter> {

  Element asElement();
  
  void setSearch(String searchName,
                 String searchCity);

  interface Presenter {

    void doClickSearchButton(String searchName,
                             String searchCity);

  }
}
