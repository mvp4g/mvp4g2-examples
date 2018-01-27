package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.core.ui.IsViewCreator;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Presenter;

@Presenter(viewClass = SearchView.class, viewInterface = ISearchView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class SearchPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus, ISearchView>
  implements ISearchView.Presenter,
             IsViewCreator<ISearchView> {

  public SearchPresenter() {
    super();
  }

  /**
   * This method wil lhandle the case, that there is no history inside the url!
   */
  @EventHandler
  public void onInitHistory() {
    onGotoSearch("",
                 "");
  }

  @EventHandler
  public void onGotoSearch(String searchName,
                           String searchCity) {
    view.setSearch(searchName,
                   searchCity);
    eventBus.setContent(view.asElement());
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

  /**
   * Because we have told mvp4g2, that this presenter will create it's view
   * (viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER), we have to
   * implement this method.
   *
   * @return a new instance of the view.
   */
  @Override
  public ISearchView createView() {
    return new SearchView();
  }
}
