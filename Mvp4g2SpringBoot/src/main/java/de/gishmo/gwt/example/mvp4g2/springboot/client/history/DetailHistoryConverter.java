package de.gishmo.gwt.example.mvp4g2.springboot.client.history;

import de.gishmo.gwt.example.mvp4g2.springboot.client.Mvp4g2SpringBootEventBus;
import de.gishmo.gwt.example.mvp4g2.springboot.client.model.ClientContext;
import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;

/**
 * The DetailHistoryConverter of the application.
 *
 * We use different HistroyConverter to check wheather the framework can
 * handle different converers or not!
 */
@History(type = History.HistoryConverterType.DEFAULT)
public class DetailHistoryConverter
  implements IsHistoryConverter<Mvp4g2SpringBootEventBus> {

  private final static String DELIMITER = "+!!+";

  public DetailHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SpringBootEventBus eventBus) {
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
