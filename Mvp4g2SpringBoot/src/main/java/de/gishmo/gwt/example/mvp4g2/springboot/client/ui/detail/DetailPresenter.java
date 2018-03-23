package de.gishmo.gwt.example.mvp4g2.springboot.client.ui.detail;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.springboot.client.Mvp4g2SpringBootEventBus;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.springboot.client.model.ClientContext;
import de.gishmo.gwt.example.mvp4g2.springboot.client.ui.AbstractSpringBootPresenter;
import com.github.mvp4g.mvp4g2.core.history.IsNavigationConfirmation;
import com.github.mvp4g.mvp4g2.core.history.NavigationEventCommand;
import com.github.mvp4g.mvp4g2.core.ui.IsViewCreator;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import elemental2.dom.DomGlobal;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

@Presenter(viewClass = DetailView.class, viewInterface = IDetailView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class DetailPresenter
  extends AbstractSpringBootPresenter<Mvp4g2SpringBootEventBus, IDetailView>
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
    ClientContext.get()
                 .getPersonService()
                 .udpate(person,
                         new MethodCallback<Void>() {
                           @Override
                           public void onFailure(Method method,
                                                 Throwable throwable) {
                             DomGlobal.alert("error: " + throwable.getMessage());
                           }

                           @Override
                           public void onSuccess(Method method,
                                                 Void aVoid) {
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

  /**
   * handles the gotoDetail-Event
   *
   * @param id id of the person to display
   */
  @EventHandler
  public void onGotoDetail(long id) {
    eventBus.setNavigationConfirmation(this);
    GWT.debugger();
    ClientContext.get()
                 .getPersonService()
                 .get(Long.toString(id),
                      new MethodCallback<Person>() {
                        @Override
                        public void onFailure(Method method,
                                              Throwable throwable) {
                          DomGlobal.alert("error: " + throwable.getMessage());
                        }

                        @Override
                        public void onSuccess(Method method,
                                              Person person) {
                          GWT.debugger();
                          view.setUpData(person);
                          eventBus.setContent(view.asElement());
                          eventBus.setStatus("Edit person data");
                        }
                      });
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
