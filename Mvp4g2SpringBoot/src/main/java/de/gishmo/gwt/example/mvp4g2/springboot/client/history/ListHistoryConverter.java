package de.gishmo.gwt.example.mvp4g2.springboot.client.history;

import de.gishmo.gwt.example.mvp4g2.springboot.client.Mvp4g2SpringBootEventBus;
import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.mvp4g2.springboot.client.model.ClientContext;
import de.gishmo.gwt.mvp4g2.core.history.IsHistoryConverter;
import de.gishmo.gwt.mvp4g2.core.history.annotation.History;

/**
 * The ListHistoryConverter of the application.
 *
 * We use different HistroyConverter to check wheather the framework can
 * handle different converers or not!
 */@History(type = History.HistoryConverterType.DEFAULT)
public class ListHistoryConverter
  implements IsHistoryConverter<Mvp4g2SpringBootEventBus> {

  private final static String DELIMITER = "+!!+";

  public ListHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SpringBootEventBus eventBus) {
    String searchName = "";
    String searchCity = "";
    if (param.length() > 0) {
      searchName = param.substring(0,
                                   param.indexOf(DELIMITER));
      if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
        searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
      }
      ClientContext.get()
                   .setPersonSearch(new PersonSearch(searchName,
                                                     searchCity));
    }
    if (searchName.length() > 0 || searchCity.length() > 0) {
      eventBus.gotoList(searchName,
                        searchCity);
    } else {
      eventBus.gotoSearch("",
                          "");
    }
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoList(String searchName,
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
