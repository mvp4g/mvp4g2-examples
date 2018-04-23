package com.github.mvp4g2.application.gxtmvp4g2application.client.history;

import com.github.mvp4g.domain.dto.shared.search.PersonSearch;
import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;
import com.github.mvp4g2.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;
import com.github.mvp4g2.application.gxtmvp4g2application.client.model.ClientContext;

@History(type = History.HistoryConverterType.SIMPLE)
public class DefaultHistoryConverter
    implements IsHistoryConverter<GxtMvp4g2ApplicationEventBus> {

  private final static String DELIMITER = "+!!+";

  public DefaultHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               GxtMvp4g2ApplicationEventBus eventBus) {
    String searchName = "";
    String searchCity = "";
    switch (historyName) {
    case "gotoSearch":
      if (param.length() > 0) {
        searchName = param.substring(0,
                                     param.indexOf(DELIMITER));
        if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
          searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
        }
      }
      ClientContext.get()
                   .setPersonSearch(new PersonSearch(cleanString(searchName),
                                                     cleanString(searchCity)));
      eventBus.gotoSearch(cleanString(searchName),
                          cleanString(searchCity));
      break;
    case "gotoList":
      if (param.length() > 0) {
        searchName = param.substring(0,
                                     param.indexOf(DELIMITER));
        if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
          searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
        }
      }
      if (searchName.length() > 0 || searchCity.length() > 0) {
        ClientContext.get()
                     .setPersonSearch(new PersonSearch(cleanString(searchName),
                                                       cleanString(searchCity)));
        eventBus.gotoList(cleanString(searchName),
                          cleanString(searchCity));
      } else {
        eventBus.gotoSearch("",
                            "");
      }
      eventBus.gotoList(cleanString(searchName),
                        cleanString(searchCity));
      break;
    case "showPerson":
      try {
        final long id = Long.parseLong(param);
        eventBus.showPerson(id);
      } catch (final NumberFormatException e) {
        if (ClientContext.get()
                         .getPersonSearch() != null) {
          ClientContext.get()
                       .setPersonSearch(new PersonSearch(cleanString(searchName),
                                                         cleanString(searchCity)));
          eventBus.gotoSearch(cleanString(ClientContext.get()
                                                       .getPersonSearch()
                                                       .getName()),
                              cleanString(ClientContext.get()
                                                       .getPersonSearch()
                                                       .getCity()));
        } else {
          eventBus.gotoSearch("",
                              "");
        }
      }
      break;
    case "newPerson":
      eventBus.newPerson();
      break;
    default:
      eventBus.gotoSearch("",
                          "");
      break;
    }
  }

  @Override
  public boolean isCrawlable() {
    return false;
  }

  public String convertToToken(final String historyName,
                               final long id) {
    return Long.toString(id);
  }

  public String convertToToken(final String historyName) {
    return "";
  }

  public String convertToToken(final String historyName,
                               final String param1,
                               final String param2) {
    return param1 + DELIMITER + param2;
  }

  private String cleanString(String value) {
    return "undefined".equals(value) ? "" : value;
  }
}
