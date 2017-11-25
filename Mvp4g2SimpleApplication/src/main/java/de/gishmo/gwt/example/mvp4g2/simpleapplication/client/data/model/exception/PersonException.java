package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public class PersonException
  extends Exception
  implements IsSerializable {

  /* for serialization only */
  @SuppressWarnings("unused")
  private PersonException() {
  }

  public PersonException(String message) {
    super(message);
  }
}
