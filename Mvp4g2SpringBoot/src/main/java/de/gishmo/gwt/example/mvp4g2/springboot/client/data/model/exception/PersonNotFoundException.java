package de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.exception;

import java.io.Serializable;

@SuppressWarnings("serial")
public class PersonNotFoundException
  extends Exception
  implements Serializable {

  /* for serialization only */
  @SuppressWarnings("unused")
  private PersonNotFoundException() {
  }

  public PersonNotFoundException(String message) {
    super(message);
  }
}
