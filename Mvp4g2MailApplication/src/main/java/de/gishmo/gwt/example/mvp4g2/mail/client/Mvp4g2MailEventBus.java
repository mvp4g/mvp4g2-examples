package de.gishmo.gwt.example.mvp4g2.mail.client;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.content.ContentPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.list.ListPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.shell.ShellPresenter;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.status.StatusPresenter;
import de.gishmo.gwt.mvp4g2.core.eventbus.IsEventBus;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.Debug;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.Event;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.EventBus;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.Start;

@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2MailEventBus
  extends IsEventBus {

  @Event
  void setCenter(Widget widget);

  @Event
  void setNorth(Widget widget);

  @Event
  void setSouth(Widget widget);

  @Start
  @Event(bind = { ListPresenter.class,
                  StatusPresenter.class,
                  ContentPresenter.class })
  void startApplication();

  @Event
  void updateStatus(String status);

  @Event
  void selectEmail(String id);

  @Event
  void addContent(String id,
                  String subject,
                  Widget widget);

  @Event
  void showContent(String id);

  @Event
  void removeEmail(String id);
}
