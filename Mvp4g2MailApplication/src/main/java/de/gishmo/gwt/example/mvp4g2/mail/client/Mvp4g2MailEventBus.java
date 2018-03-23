package de.gishmo.gwt.example.mvp4g2.mail.client;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.content.ContentPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.list.ListPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.shell.ShellPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.status.StatusPresenter;
import com.github.mvp4g.mvp4g2.core.eventbus.IsEventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Debug;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Event;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.EventBus;
import com.github.mvp4g.mvp4g2.core.eventbus.annotation.Start;

@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2MailEventBus
  extends IsEventBus {

  /**
   * sets the center widget in the shell
   *
   * @param widget the new center widget
   */
  @Event
  void setCenter(Widget widget);

  /**
   * sets the north widget in the shell
   *
   * @param widget the new north widget
   */
  @Event
  void setNorth(Widget widget);

  /**
   * sets the south widget in the shell
   *
   * @param widget the new south widget
   */
  @Event
  void setSouth(Widget widget);

  /**
   * this event is fired at application start. Because it is marked with @Start
   * the vent will be fired by the framework.
   *
   * we use this event to initialize the application layout
   * by using the bind-feature and load the list of mails
   */
  @Start
  @Event(bind = { ListPresenter.class,
                  StatusPresenter.class,
                  ContentPresenter.class })
  void startApplication();

  /**
   * updates the content of the status bar
   *
   * @param status new text of the status bar
   */
  @Event
  void updateStatus(String status);

  /**
   * selects the email with the id and display it.
   *
   * @param id of the email
   */
  @Event
  void selectEmail(String id);

  /**
   * displays an email in the content area
   *
   * @param id of the email
   * @param subject text of the tab
   * @param widget widget to display
   */
  @Event
  void addContent(String id,
                  String subject,
                  Widget widget);


  /**
   * brings an email to front
   *
   * @param id of hte email
   */
  @Event
  void showContent(String id);

  /**
   * removes an email from the content area
   *
   * @param id of the email
   */
  @Event
  void removeEmail(String id);

}
