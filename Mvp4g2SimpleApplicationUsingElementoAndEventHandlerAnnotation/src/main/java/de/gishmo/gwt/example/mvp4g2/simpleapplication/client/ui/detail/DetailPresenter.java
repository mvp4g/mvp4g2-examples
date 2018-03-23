package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception.PersonNotFoundException;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.service.PersonService;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.AbstractSimpleApplicationPresenter;
import com.github.mvp4g.mvp4g2.core.history.IsNavigationConfirmation;
import com.github.mvp4g.mvp4g2.core.history.NavigationEventCommand;
import com.github.mvp4g.mvp4g2.core.ui.IsViewCreator;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import elemental2.dom.DomGlobal;

@Presenter(viewClass = DetailView.class, viewInterface = IDetailView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class DetailPresenter
  extends AbstractSimpleApplicationPresenter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus, IDetailView>
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

  /**
   * handles the gotoDetail-Event
   *
   * @param id id of the person to display
   */
  @EventHandler
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

  /**
   * This method will be called from the framework. The DetailPresenter can decide
   * weather the next event will be exceuted or not.
   *
   * @param event command representation of the event to confirm or stop
   */
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

  /**
   * Because we have told mvp4g2, that this presenter will create it's view
   * (viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER), we have to
   * implement this method.
   *
   * @return a new instance of the view.
   */
  @Override
  public IDetailView createView() {
    return new DetailView();
  }
}
