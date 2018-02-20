package de.gishmo.gwt.example.mvp4g2.mail.client.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import de.gishmo.gwt.example.mvp4g2.mail.shared.dto.Mail;

public interface MailProperties
  extends PropertyAccess<Mail> {

  @Editor.Path("id")
  ModelKeyProvider<Mail> key();

  @Editor.Path("sender")
  ValueProvider<Mail, String> sender();

  @Editor.Path("email")
  ValueProvider<Mail, String> email();

  @Editor.Path("subject")
  ValueProvider<Mail, String> subject();

  @Editor.Path("body")
  ValueProvider<Mail, String> body();

  @Editor.Path("read")
  ValueProvider<Mail, Boolean> read();

}
