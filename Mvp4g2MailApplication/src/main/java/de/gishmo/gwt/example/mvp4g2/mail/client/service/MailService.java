package de.gishmo.gwt.example.mvp4g2.mail.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;

import java.util.ArrayList;

@RemoteServiceRelativePath("mailService")
public interface MailService
  extends RemoteService {

  ArrayList<Mail> getAllMails();

  Mail getMail(String mailId);

}
