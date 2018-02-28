package de.gishmo.gwt.example.mvp4g2.mail.client.model;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailService;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailServiceAsync;

public class ClientContext {

  private static ClientContext    instance;
  /* Service */
  private        MailServiceAsync mailService;

  private ClientContext() {
    mailService = GWT.create(MailService.class);
  }

  public static ClientContext get() {
    if (instance == null) {
      instance = new ClientContext();
    }
    return instance;
  }

  public MailServiceAsync getMailService() {
    return mailService;
  }
}
