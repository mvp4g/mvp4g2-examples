package tld.domain.project.dto.shared.transport;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReturnCode {

  OK("200",
     "OK"),
  BUSINESS_ERROR("300",
                 "BUSINESS_ERROR"),
  TTECHNICAL_ERROR("500",
                   "TTECHNICAL_ERROR");

  private String statusCode;
  private String status;

  ReturnCode(final String statusCode,
             final String status) {
    this.statusCode = statusCode;
    this.status = status;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
