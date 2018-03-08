package de.gishmo.gwt.example.mvp4g2.mail.client.model;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailService;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailServiceAsync;

/**
 * we will use this class as 'client-sided session container'
 */
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

  /**
   * our email service ...
   *
   * @return instace of the email service
   */
  public MailServiceAsync getMailService() {
    return mailService;
  }
}
