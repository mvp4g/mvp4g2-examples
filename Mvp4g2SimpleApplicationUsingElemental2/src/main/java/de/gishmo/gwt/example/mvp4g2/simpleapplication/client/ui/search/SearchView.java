package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.search;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import de.gishmo.gwt.mvp4g2.client.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static elemental2.dom.DomGlobal.document;


public class SearchView
  extends LazyReverseView<ISearchView.Presenter>
  implements ISearchView {

  private HTMLDivElement    panel;
  private TextField         searchName;
  private TextField         searchCity;
  private HTMLButtonElement searchButton;
  private HTMLButtonElement resetButton;

  public SearchView() {
    super();
  }

  @Override
  public void setSearch(String searchName,
                        String searchCity) {
    this.searchName.setText(searchName);
    this.searchCity.setText(searchCity);
  }

  public void bind() {
    searchButton.addEventListener("click", (e) -> {
      getPresenter().doClickSearchButton(searchName.getText(),
                                         searchCity.getText());
    });

    resetButton.addEventListener("click", (e) -> {
      searchName.setText("");
      searchCity.setText("");
    });
  }

  public void createView() {
    panel = (HTMLDivElement) document.createElement("div");

    HTMLDivElement searchPanel = (HTMLDivElement) document.createElement("div");
    searchPanel.className = "searchPanel";
    panel.appendChild(searchPanel);

    HTMLDivElement headline = (HTMLDivElement) document.createElement("div");
    headline.innerHTML = "Search Parameter";
    headline.className = "headline";
    searchPanel.appendChild(headline);

    searchName = new TextField("Name");
    searchPanel.appendChild(searchName.getElement());

    searchCity = new TextField("City");
    searchPanel.appendChild(searchCity.getElement());

    HTMLDivElement buttonBar = (HTMLDivElement) document.createElement("div");
    buttonBar.className = "searchPanelButtonBar";
    searchPanel.appendChild(buttonBar);

    searchButton = (HTMLButtonElement) document.createElement("button");
    searchButton.textContent = "Search";
    searchButton.className = "button";
    buttonBar.appendChild(searchButton);

    resetButton = (HTMLButtonElement) document.createElement("button");
    resetButton.textContent = "Reset";
    resetButton.className = "button";
    buttonBar.appendChild(resetButton);
  }

  @Override
  public Element asElement() {
    return panel;
  }
}

