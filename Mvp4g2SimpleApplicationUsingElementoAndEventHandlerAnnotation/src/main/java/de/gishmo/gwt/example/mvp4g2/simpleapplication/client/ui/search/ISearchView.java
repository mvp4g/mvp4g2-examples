package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import elemental2.dom.Element;

public interface ISearchView
  extends IsLazyReverseView<ISearchView.Presenter> {

  /**
   * mvp4g2 does not know Widget-, Element- or any other class. So, the
   * presenter have to manage the widget by themselves. The method will
   * enable the presenter to get the view. (In our case it is a
   * Elemental 2 element!)
   *
   * @return The search view element
   */
  Element asElement();

  void setSearch(String searchName,
                 String searchCity);

  interface Presenter {

    void doClickSearchButton(String searchName,
                             String searchCity);

  }
}
