package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service.PersonService;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.IsViewCreator;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.EventHandler;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;

import java.util.List;

@Presenter(viewClass = ListView.class, viewInterface = IListView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class ListPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus, IListView>
  implements IListView.Presenter,
             IsViewCreator<IListView> {

  public ListPresenter() {
    super();
  }

  @Override
  public void doUpdate(Person object) {
    eventBus.gotoDetail(object.getId());
  }

  @EventHandler
  public void onGotoList(String searchName,
                         String searchCity) {
    List<Person> result = PersonService.get()
                                       .get(new PersonSearch(searchName,
                                                             searchCity));
    view.resetTable();
    view.setData(result);
    eventBus.setContent(view.asElement());
    if (result.size() == 0) {
      eventBus.setStatus("No person found");
    } else if (result.size() == 1) {
      eventBus.setStatus("Found one person");
    } else {
      eventBus.setStatus("Found " + Integer.toString(result.size()) + " persons");
    }
  }

  @Override
  public IListView createView() {
    return new ListView();
  }
}
