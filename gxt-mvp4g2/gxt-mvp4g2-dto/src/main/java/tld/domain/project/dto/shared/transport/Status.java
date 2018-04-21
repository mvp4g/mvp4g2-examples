package tld.domain.project.dto.shared.transport;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import tld.domain.project.dto.shared.AbstractDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JsonTypeName("Status")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
@XmlRootElement
public class Status
  extends AbstractDto {

  private ReturnCode   returnCode;
  private List<String> businessMessages;
  private String       technicalMessages;

  public Status() {
    super();
    this.returnCode = ReturnCode.OK;
    this.businessMessages = new ArrayList<>();
    this.technicalMessages = null;
  }

  public ReturnCode getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(ReturnCode returnCode) {
    this.returnCode = returnCode;
  }

  public void add(String meldungFachlich) {
    this.businessMessages.add(meldungFachlich);
  }

  public List<String> getBusinessMessages() {
    return businessMessages;
  }

  public void setBusinessMessages(List<String> businessMessages) {
    this.businessMessages = businessMessages;
  }

  public String getTechnicalMessages() {
    return technicalMessages;
  }

  public void setTechnicalMessages(String technicalMessages) {
    if (technicalMessages != null && !technicalMessages.trim()
                                                       .isEmpty()) {
      this.returnCode = ReturnCode.TTECHNICAL_ERROR;
    }
    this.technicalMessages = technicalMessages;
  }
}
