package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationMessages;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;

import java.util.List;

@Presenter(viewClass = ListView.class, viewInterface = IListView.class)
public class ListPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus, IListView>
  implements IListView.Presenter {

  public ListPresenter() {
    super();
  }

  @Override
  public void doUpdate(Person object) {
    eventBus.gotoDetail(object.getId());
  }

  public void onGotoList(String searchName,
                         String searchCity) {
    List<Person> result = PersonService.get()
                                       .get(new PersonSearch(searchName,
                                                             searchCity));
    view.resetTable();
    view.setData(result);
    eventBus.setContent(view.asWidget());
    if (result.size() == 0) {
      eventBus.setStatus(ApplicationConstants.CONSTANTS.statusListZero());
    } else if (result.size() == 1) {
      eventBus.setStatus(ApplicationConstants.CONSTANTS.statusListOne());
    } else {
      eventBus.setStatus(ApplicationMessages.MESSAGES.statusListMany(result.size()));
    }
  }
}
