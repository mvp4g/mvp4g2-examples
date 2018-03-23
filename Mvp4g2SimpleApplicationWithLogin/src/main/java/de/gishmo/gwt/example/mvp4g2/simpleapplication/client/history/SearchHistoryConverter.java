package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationWithLoginEventBus;
import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;

@History(type = History.HistoryConverterType.DEFAULT)
public class SearchHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationWithLoginEventBus> {

  private final static String DELIMITER = "+!!+";

  public SearchHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SimpleApplicationWithLoginEventBus eventBus) {
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
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoSearch(String searchName,
                             String searchCity) {
    return convertParameter(searchName) + DELIMITER + convertParameter(searchCity);
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
