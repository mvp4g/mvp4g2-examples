package com.github.mvp4g2.application.gxtmvp4g2application.client.service.utils;


import com.github.mvp4g.domain.dto.shared.transport.ExceptionInfo;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.Services;
import com.github.mvp4g2.application.gxtmvp4g2application.client.service.dto.ExceptionInfoService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Header;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.Window;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

/**
 * <p>
 * In dieser Klasse werden generelle Utility-Funktionen definiert.
 * </p>
 */
public class ExceptionUtils {

  private static ExceptionUtils instance;

  private ExceptionUtils() {
  }

  public static ExceptionUtils get() {
    if (instance == null) {
      instance = new ExceptionUtils();
    }
    return instance;
  }

  public void showExceptionMessageForServerCallFailureWithExitApplication(Class<?> clazz,
                                                                          String methodName,
                                                                          Method method,
                                                                          Throwable caught) {
    SafeHtml failureMessage = createExceptionMessageForServerCallFailure(method,
                                                                         clazz == null ? methodName : createClassMethodString(clazz,
                                                                                                                              methodName),
                                                                         caught);
    // Wenn der SuperDevMode aktiviert ist, möchten wir gerne die Exception
    // sehen, andernfalls die vereinfachte Version mit Hinweistext.
    if (!(Window.Location.getHostName()
                         .toLowerCase()
                         .contains("localhost") || Window.Location.getHostName()
                                                                  .contains("127.0.0.1")
    )) {
      SafeHtml message = createExceptionMessageForServerCallFailureSimplified(method,
                                                                              clazz == null ? methodName : createClassMethodString(clazz,
                                                                                                                                   methodName),
                                                                              caught);
      Window.alert(message.toString());
      writeExceptionToServer(caught,
                             methodName,
                             "Technischer Fehler aufgetreten!");

    } else {
      Window.alert(failureMessage.toString());
    }
  }

  public SafeHtml createExceptionMessageForServerCallFailure(Method method,
                                                             String methodName,
                                                             Throwable throwable) {
    StringBuilder message = new StringBuilder();
    Exception exception = (Exception) throwable;
    // Fehlermeldung
    message.append(ExceptionUtilsConstants.INSTANCE.serverErrorText())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.serverErrorMessage())
           .append("<br/>")
           .append(exception.getMessage())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.methodName())
           .append("<br/>")
           .append(methodName)
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.serverMessageStatus())
           .append("<br/>")
           .append(method.getResponse()
                         .getStatusCode())
           .append(" ")
           .append(method.getResponse()
                         .getStatusText())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.serverErrorPayload())
           .append("<br/>")
           .append(method.getResponse()
                         .getText())
           .append("<br/><br/>");

    message.append(ExceptionUtilsConstants.INSTANCE.serverErrorData())
           .append("<br/>");
    if (method.getData()
              .size() > 0) {
      message.append("<table>");
      for (String key : method.getData()
                              .keySet()) {
        message.append("<tr><td style=\"white-space: nowrap; vertical-align:top;\">")
               .append(key)
               .append(":&nbsp;</td><td>")
               .append(method.getData()
                             .get(key))
               .append("</td></tr>");
      }
      message.append("</table>");
    } else {
      message.append(ExceptionUtilsConstants.INSTANCE.serverNoResponseDataExist());
    }

    message.append("<br/><br/>");

    message.append(ExceptionUtilsConstants.INSTANCE.serverMessageResponseHeader())
           .append("<br/>");
    if (method.getResponse()
              .getHeaders().length > 0) {
      message.append("<table>");
      for (Header header : method.getResponse()
                                 .getHeaders()) {
        message.append("<tr><td style=\"white-space: nowrap; vertical-align:top;\">")
               .append(header.getName())
               .append(":&nbsp;</td><td>")
               .append(header.getValue())
               .append("</td></tr>");
      }
      message.append("</table>");
    } else {
      message.append(ExceptionUtilsConstants.INSTANCE.serverNoRespneseHeaderInforamationExist());
    }
    return SafeHtmlUtils.fromTrustedString(message.toString());
  }

  private String createClassMethodString(Class<?> clazz,
                                         String methodName) {
    return clazz.getCanonicalName() + " / " + methodName;
  }

  public SafeHtml createExceptionMessageForServerCallFailureSimplified(Method method,
                                                                       String methodName,
                                                                       Throwable throwable) {
    return SafeHtmlUtils.fromTrustedString(ExceptionUtilsConstants.INSTANCE.serverTechnischerFehler());
  }

  public void writeExceptionToServer(Throwable throwable,
                                     String methodName,
                                     String message) {
    ExceptionInfoService exceptionInfoService = Services.get()
                                                        .getExceptionInfoService();
    exceptionInfoService.log(new ExceptionInfo(throwable,
                                               methodName,
                                               message,
                                               GWT.getModuleBaseURL()),
                             new MethodCallback<Void>() {
                               @Override
                               public void onFailure(Method method,
                                                     Throwable exception) {
                                 // noop
                               }

                               @Override
                               public void onSuccess(Method method,
                                                     Void response) {
                                 // noop
                               }
                             });
  }

  public void showException(String methodName,
                            Throwable throwable) {
    if (throwable instanceof Exception) {
      Window.alert(createExceptionMessage(methodName,
                                          throwable).toString());
    } else if (throwable instanceof AssertionError) {
      Window.alert(createExceptionMessage(methodName,
                                          throwable).toString());
    }
  }

  public SafeHtml createExceptionMessage(String methodName,
                                         Throwable throwable) {
    Exception exception = (Exception) throwable;
    // Fehlermeldung
    StringBuilder message = new StringBuilder();
    message.append(ExceptionUtilsConstants.INSTANCE.applicationErrorText())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.applicationErrorMessage())
           .append("<br/>")
           .append(exception.getMessage())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.methodName())
           .append("<br/>")
           .append(methodName)
           .append("<br/><br/>");

    message.append(ExceptionUtilsConstants.INSTANCE.applicationErrorStackTrace())
           .append("<br/>");
    for (StackTraceElement element : exception.getStackTrace()) {
      message.append(element.getMethodName())
             .append("(")
             .append(element.getClassName())
             .append(":")
             .append(element.getLineNumber())
             .append(")<br/>");
    }
    return SafeHtmlUtils.fromTrustedString(message.toString());
  }

  public SafeHtml createAssertionErrorMessage(String methodName,
                                              Throwable throwable) {
    AssertionError assertionError = (AssertionError) throwable;
    // Fehlermeldung
    StringBuilder message = new StringBuilder();
    message.append(ExceptionUtilsConstants.INSTANCE.applicationErrorText())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.applicationErrorMessage())
           .append("<br/>")
           .append(assertionError.getMessage())
           .append("<br/><br/>")
           .append(ExceptionUtilsConstants.INSTANCE.methodName())
           .append("<br/>")
           .append(methodName)
           .append("<br/><br/>");

    message.append(ExceptionUtilsConstants.INSTANCE.applicationErrorStackTrace())
           .append("<br/>");
    for (StackTraceElement element : assertionError.getStackTrace()) {
      message.append(element.getMethodName())
             .append("(")
             .append(element.getClassName())
             .append(":")
             .append(element.getLineNumber())
             .append(")<br/>");
    }
    return SafeHtmlUtils.fromTrustedString(message.toString());
  }
}
