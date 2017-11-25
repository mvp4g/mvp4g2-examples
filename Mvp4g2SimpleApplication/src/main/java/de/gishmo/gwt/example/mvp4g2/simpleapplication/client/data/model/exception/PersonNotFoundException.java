package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception;

import com.google.gwt.user.client.rpc.IsSerializable;

@SuppressWarnings("serial")
public class PersonNotFoundException
  extends Exception
  implements IsSerializable {

  /* for serialization only */
  @SuppressWarnings("unused")
  private PersonNotFoundException() {
  }

  public PersonNotFoundException(String message) {
    super(message);
  }
}
