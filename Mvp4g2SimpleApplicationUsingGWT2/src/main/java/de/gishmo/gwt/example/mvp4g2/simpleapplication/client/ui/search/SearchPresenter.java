package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.PersonSearch;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.IsViewCreator;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = SearchView.class, viewInterface = ISearchView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class SearchPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus, ISearchView>
  implements ISearchView.Presenter,
             IsViewCreator<ISearchView> {

  public SearchPresenter() {
    super();
  }

  public void onInitHistory() {
    onGotoSearch("",
                 "");
  }

  public void onGotoSearch(String searchName,
                           String searchCity) {
    view.setSearch(searchName,
                   searchCity);
    eventBus.setContent(view.asWidget());
  }

  @Override
  public void doClickSearchButton(String searchName,
                                  String searchCity) {
    // fuer NavigatiponPresenter speichern ...
    ClientContext.get()
                 .setPersonSearch(new PersonSearch(searchName,
                                                   searchCity));
    eventBus.gotoList(searchName,
                      searchCity);
  }

  @Override
  public ISearchView createView() {
    return GWT.create(ISearchView.class);
  }
}
