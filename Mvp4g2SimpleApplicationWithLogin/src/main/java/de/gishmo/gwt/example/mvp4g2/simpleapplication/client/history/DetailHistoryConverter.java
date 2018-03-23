package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.history;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.Mvp4g2SimpleApplicationWithLoginEventBus;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.model.ClientContext;
import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;

@History(type = History.HistoryConverterType.DEFAULT)
public class DetailHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationWithLoginEventBus> {

  private final static String DELIMITER = "+!!+";

  public DetailHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SimpleApplicationWithLoginEventBus eventBus) {
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
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoDetail(long id) {
    return Long.toString(id);
  }
}
