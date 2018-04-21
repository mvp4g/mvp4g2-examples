package com.github.mvp4g2.application.gxtmvp4g2application.client.service.utils;


import com.github.mvp4g.domain.dto.shared.transport.ReturnCode;
import com.github.mvp4g.domain.dto.shared.transport.response.AbstractResponse;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.exception.ServerCommunicationException;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import org.fusesource.restygwt.client.Method;

public class ResponseHandler {

  private Class<?>         callingClazz;
  private String           callingMethod;
  private Method           method;
  private AbstractResponse response;
  private Command          commandOk;

  private ResponseHandler(Builder builder) {
    assert builder.callingClazz != null : "der Referenz auf die aufrufende Klasse ist nicht gefuellt";
    assert builder.callingMethod != null : "der Name der aufrufenden Methode ist nicht gefuellt";
    assert builder.method != null : "die Response-Methode ist nicht gefuellt";
    assert builder.response != null : "die Response ist nicht gefuellt";
    assert builder.commandOk != null : "Das Command, das ausgefuehrt werden soll, wenn der Statuscode OK ist, ist nicht gefuellt";

    this.callingClazz = builder.callingClazz;
    this.callingMethod = builder.callingMethod;
    this.method = builder.method;
    this.response = builder.response;
    this.commandOk = builder.commandOk;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * <p>Verarbeite die Response!</p>
   */
  public void handle() {
    if (response == null) {
      // Bildschirm entsperren
      // TODO Bildschirm entsperren
      // Fehlermeldung ausgeben
      ExceptionUtils.get()
                    .showExceptionMessageForServerCallFailureWithExitApplication(callingClazz,
                                                                                 callingMethod,
                                                                                 method,
                                                                                 new ServerCommunicationException("Keine Antwort vom Server erhalten ..."));
      return;
    }
    if (ReturnCode.TECHNICAL_ERROR.equals(response.getStatus()
                                                  .getReturnCode())) {
      // Bildschirm entsperren
      // TODO Bildschirm entsperren
      // Fehlermeldung ausgeben
      ExceptionUtils.get()
                    .showExceptionMessageForServerCallFailureWithExitApplication(callingClazz,
                                                                                 callingMethod,
                                                                                 method,
                                                                                 new ServerCommunicationException(response.getStatus()
                                                                                                                          .getTechnicalMessages()));
    } else {
      // Fachliche Meldungen ausgeben, wenn vorhanden ...
      if (response.getStatus()
                  .getBusinessMessages() != null &&
          response.getStatus()
                  .getBusinessMessages()
                  .size() > 0) {
        Window.alert(response.getStatus()
                             .getBusinessMessages()
                             .toString());
      }
      // Verarbeitung ausfuehren, wenn der Call OK ist ...
      if (ReturnCode.OK.equals(response.getStatus()
                                       .getReturnCode())) {
        if (commandOk != null) {
          commandOk.execute();
        }
      }
    }

  }

  public static class Builder {
    Class<?>         callingClazz;
    String           callingMethod;
    Method           method;
    AbstractResponse response;
    Command          commandOk;
    Command          commandNotOk;

    /**
     * <p>Setzen der aufrufenden Klasse</p>
     *
     * @param callingClazz aufrufende Klasse
     * @return ResponseHandler.Builder
     */
    public Builder callingClass(Class<?> callingClazz) {
      this.callingClazz = callingClazz;
      return this;
    }

    /**
     * <p>Setzen des Namens der aufrufenden Methopde</p>
     *
     * @param callingMethod Name der aufrufenden Klasse
     * @return ResponseHandler.Builder
     */
    public Builder callingMethod(String callingMethod) {
      this.callingMethod = callingMethod;
      return this;
    }

    /**
     * <p>Setzen der Methode der Response</p>
     *
     * @param method Methode der Response
     * @return ResponseHandler.Builder
     */
    public Builder responseMethod(Method method) {
      this.method = method;
      return this;
    }

    /**
     * <p>Setzen des Response</p>
     *
     * @param response der Response
     * @return ResponseHandler.Builder
     */
    public Builder response(AbstractResponse response) {
      this.response = response;
      return this;
    }

    /**
     * <p>Setzen des Commands, das ausgefuehrt werden soll, wenn der Call erfolgreich war (Statusode: OK)</p>
     *
     * @param commandOk der Command
     * @return ResponseHandler.Builder
     */
    public Builder executeIfStatuscodeIsOk(Command commandOk) {
      this.commandOk = commandOk;
      return this;
    }

    /**
     * <p>Setzen des Commands, das ausgefuehrt werden soll, wenn der Call nicht erfolgreich war (Statusode: OK)</p>
     *
     * @param commandNotOk der Command
     * @return ResponseHandler.Builder
     */
    public Builder executeIfStatuscodeIsNotOk(Command commandNotOk) {
      this.commandNotOk = commandNotOk;
      return this;
    }

    public ResponseHandler build() {
      return new ResponseHandler(this);
    }
  }
}
