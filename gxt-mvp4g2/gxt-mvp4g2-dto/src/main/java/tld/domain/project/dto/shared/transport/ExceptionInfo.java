package tld.domain.project.dto.shared.transport;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("ExceptionInfo")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
public class ExceptionInfo
  extends LoggingInfo {

  private String exceptionMessage;

  public ExceptionInfo() {
  }

  public ExceptionInfo(Throwable throwable,
                       String pMethode,
                       String pMessage,
                       String pParameter) {
    super(Loglevel.ERROR,
          pMethode,
          pMessage,
          pParameter);
    exceptionMessage = throwable.getMessage();
  }

  public String getExceptionMessage() {
    return exceptionMessage;
  }

  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();

    buffer.append(super.toString());

    buffer.append("exceptionMessage=");
    if (exceptionMessage != null) {
      buffer.append(exceptionMessage);
      buffer.append(";");
    } else {
      buffer.append("NULL;");
    }

    return buffer.toString();
  }
}
