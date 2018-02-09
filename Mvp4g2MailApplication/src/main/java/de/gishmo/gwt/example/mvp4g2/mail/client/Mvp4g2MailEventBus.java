package de.gishmo.gwt.example.mvp4g2.mail.client;

import de.gishmo.gwt.example.mvp4g2.mail.client.ui.shell.ShellPresenter;
import de.gishmo.gwt.mvp4g2.core.eventbus.IsEventBus;
import de.gishmo.gwt.mvp4g2.core.eventbus.annotation.EventBus;

@EventBus(shell = ShellPresenter.class)
public interface Mvp4g2MailEventBus
  extends IsEventBus {
}
