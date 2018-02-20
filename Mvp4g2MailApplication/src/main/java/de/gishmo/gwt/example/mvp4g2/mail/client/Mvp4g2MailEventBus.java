package de.gishmo.gwt.example.mvp4g2.mail.client;

import com.google.gwt.user.client.ui.Widget;
import de.gishmo.gwt.example.mvp4g2.mail.client.ui.shell.ShellPresenter;
import de.gishmo.gwt.mvp4g2.core.eventbus.IsEventBus;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.Debug;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.Event;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.EventBus;

@EventBus(shell = ShellPresenter.class)
@Debug(logLevel = Debug.LogLevel.DETAILED)
public interface Mvp4g2MailEventBus
  extends IsEventBus {

//  @EventHandler
  @Event
  void addMailList();

  @Event
  void addStatusBar();

  @Event
  void setNorth(Widget widget);

  @Event
  void setSouth(Widget widget);

}
