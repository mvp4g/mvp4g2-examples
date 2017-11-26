package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import com.google.gwt.user.client.Window;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonNotFoundException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.mvp4g2.client.history.IsNavigationConfirmation;
import de.gishmo.gwt.mvp4g2.client.history.NavigationEventCommand;
import de.gishmo.gwt.mvp4g2.client.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;

@Presenter(viewClass = DetailView.class, viewInterface = IDetailView.class)
public class DetailPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationEventBus, IDetailView>
  implements IDetailView.Presenter,
             IsNavigationConfirmation {

  public DetailPresenter() {
  }

  @Override
  public void doRevert() {
    eventBus.gotoList(ClientContext.get()
                                   .getPersonSearch()
                                   .getName(),
                      ClientContext.get()
                                   .getPersonSearch()
                                   .getCity());
  }

  @Override
  public void doUpdate(Person person) {
    try {
      PersonService.get()
                   .update(person);
      if (ClientContext.get()
                       .getPersonSearch() == null) {
        eventBus.gotoSearch("",
                            "");
      } else {
        eventBus.gotoList(ClientContext.get()
                                       .getPersonSearch()
                                       .getName(),
                          ClientContext.get()
                                       .getPersonSearch()
                                       .getCity());
      }
    } catch (PersonException e) {
      Window.alert("Panic!");
    }
  }

  public void onGotoDetail(long id) {
    eventBus.setNavigationConfirmation(this);
    try {
      Person result = PersonService.get()
                                   .get(id);
      view.setUpData(result);
      eventBus.setContent(view.asWidget());
      eventBus.setStatus(ApplicationConstants.CONSTANTS.statusDetail());
    } catch (PersonNotFoundException e) {
      Window.alert("Panic!");
    }
  }

  @Override
  public void confirm(NavigationEventCommand event) {
    if (view.isDirty()) {
      if (Window.confirm("Wollen Sie wirklich Ihre Aendeurngen verwerfen?")) {
        event.fireEvent();
      }
    } else {
      event.fireEvent();
    }
  }
}
