package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.shared.dto.Person;
import de.gishmo.gwt.mvp4g2.core.history.IsNavigationConfirmation;
import de.gishmo.gwt.mvp4g2.core.history.NavigationEventCommand;
import de.gishmo.gwt.mvp4g2.core.ui.AbstractPresenter;
import de.gishmo.gwt.mvp4g2.core.ui.annotation.Presenter;

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
    ClientContext.get()
                 .getPersonService()
                 .update(person,
                         new AsyncCallback<Void>() {
                           @Override
                           public void onFailure(Throwable caught) {
                             Window.alert("PANIC!!!!");
                           }

                           @Override
                           public void onSuccess(Void result) {
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
                           }
                         });
  }

  public void onGotoDetail(long id) {
    eventBus.setNavigationConfirmation(this);
    ClientContext.get()
                 .getPersonService()
                 .get(id,
                      new AsyncCallback<Person>() {
                        @Override
                        public void onFailure(Throwable caught) {
                          Window.alert("PANIC!!!!");
                        }

                        @Override
                        public void onSuccess(Person result) {
                          view.setUpData(result);
                          eventBus.setContent(view.asWidget());
                          eventBus.setStatus(ApplicationConstants.CONSTANTS.statusDetail());
                        }
                      });
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
