package de.gishmo.gwt.example.mvp4g2.mail.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;

import java.util.ArrayList;

public interface MailServiceAsync {
  void getAllMails(AsyncCallback<ArrayList<Mail>> async);

  void getMail(String mailId,
               AsyncCallback<Mail> async);
}
