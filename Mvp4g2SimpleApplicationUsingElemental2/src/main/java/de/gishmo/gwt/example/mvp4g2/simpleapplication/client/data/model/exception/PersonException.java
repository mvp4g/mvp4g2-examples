package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonException
  extends Exception
  implements Serializable {

  /* for serialization only */
  @SuppressWarnings("unused")
  private PersonException() {
  }

  public PersonException(String message) {
    super(message);
  }
}
