package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;

@History(type = History.HistoryConverterType.SIMPLE)
public class DefaultHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationEventBus> {

  private final static String DELIMITER = "+!!+";

  public DefaultHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SimpleApplicationEventBus eventBus) {

    if ("gotoSearch".equals(historyName)) {
      String searchName = "";
      String searchCity = "";
      if (param.length() > 0) {
        searchName = param.substring(0,
                                     param.indexOf(DELIMITER));
        if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
          searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
        }
      }
      eventBus.gotoSearch(searchName,
                          searchCity);
    } else if ("gotoList".equals(historyName)) {
      String searchName = "";
      String searchCity = "";
      if (param.length() > 0) {
        searchName = param.substring(0,
                                     param.indexOf(DELIMITER));
        if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
          searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
        }
      }
      if (searchName.length() > 0 || searchCity.length() > 0) {
        eventBus.gotoList(searchName,
                          searchCity);
      } else {
        eventBus.gotoSearch("",
                            "");
      }
    } else if ("gotoDetail".equals(historyName)) {
      try {
        long id = Long.parseLong(param);
        eventBus.gotoDetail(id);
      } catch (NumberFormatException e) {
        if (ClientContext.get()
                         .getPersonSearch() != null) {
          eventBus.gotoSearch(ClientContext.get()
                                           .getPersonSearch()
                                           .getName(),
                              ClientContext.get()
                                           .getPersonSearch()
                                           .getCity());
        } else {
          eventBus.gotoSearch("",
                              "");
        }
      }
    } else {
      // Defaultwerte setzen ....
      eventBus.gotoSearch("",
                          "");
    }
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String convertToToken(String historyName,
                               long id) {
    return Long.toString(id);
  }

  public String convertToToken(String historyName) {
    return "";
  }

  public String convertToToken(String historyName,
                               String param1,
                               String param2) {
    return convertParameter(param1) + DELIMITER + convertParameter(param1);
  }

  private String convertParameter(String param) {
    if (param == null) {
      return "";
    }
    if ("undefined".equals(param)) {
      return "";
    }
    return param;
  }
}
