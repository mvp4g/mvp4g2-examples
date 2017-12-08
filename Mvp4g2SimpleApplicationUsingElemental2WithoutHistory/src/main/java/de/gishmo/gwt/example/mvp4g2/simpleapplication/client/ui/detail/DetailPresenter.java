package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonNotFoundException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.AbstractSimpleApplicationPresenter;
import de.gishmo.gwt.mvp4g2.client.history.IsNavigationConfirmation;
import de.gishmo.gwt.mvp4g2.client.history.NavigationEventCommand;
import de.gishmo.gwt.mvp4g2.client.ui.IsViewCreator;
import de.gishmo.gwt.mvp4g2.client.ui.annotation.Presenter;
import elemental2.dom.DomGlobal;

@Presenter(viewClass = DetailView.class, viewInterface = IDetailView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class DetailPresenter
  extends AbstractSimpleApplicationPresenter<Mvp4g2SimpleApplicationEventBus, IDetailView>
  implements IDetailView.Presenter,
             IsNavigationConfirmation,
             IsViewCreator<IDetailView> {

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
      DomGlobal.window.alert("Panic!");
    }
  }

  public void onGotoDetail(long id) {
    eventBus.setNavigationConfirmation(this);
    try {
      Person result = PersonService.get()
                                   .get(id);
      view.setUpData(result);
      eventBus.setContent(view.asElement());
      eventBus.setStatus("Edit person data");
    } catch (PersonNotFoundException e) {
      DomGlobal.window.alert("Panic!");
    }
  }

  @Override
  public void confirm(NavigationEventCommand event) {
    if (view.isDirty()) {
      if ((Boolean) DomGlobal.window.confirm("Wollen Sie wirklich Ihre Aendeurngen verwerfen?")) {
        event.fireEvent();
      }
    } else {
      event.fireEvent();
    }
  }

  @Override
  public IDetailView createView() {
    return new DetailView();
  }
}