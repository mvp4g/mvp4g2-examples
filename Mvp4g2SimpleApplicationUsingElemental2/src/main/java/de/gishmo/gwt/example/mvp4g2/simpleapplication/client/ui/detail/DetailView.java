package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.ui.UiUtils;
import de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets.TextField;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;

import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static elemental2.dom.DomGlobal.document;


public class DetailView
  extends LazyReverseView<IDetailView.Presenter>
  implements IDetailView {

  private HTMLDivElement panel;

  private TextField detailFirstName;
  private TextField detailName;
  private TextField detailStreet;
  private TextField detailZip;
  private TextField detailCity;
  
  private HTMLButtonElement saveButton;
  private HTMLButtonElement            revertButton;

  private Person person;

  public DetailView() {
    super();
  }

  @Override
  public boolean isDirty() {
    boolean notDirty = (person.getFirstName().equals(detailFirstName.getText())) &&
                       (person.getName().equals(detailName.getText())) &&
                       (person.getAddress().getStreet().equals(detailStreet.getText())) &&
                       (person.getAddress().getZip().equals(detailZip.getText())) &&
                       (person.getAddress().getCity().equals(detailCity.getText()));
    return !notDirty;
  }

  @Override
  public void setUpData(Person person) {
    this.person = person;
    setDetailForm();
  }

  public void bind() {
    saveButton.addEventListener("click", (e) -> {
      updateDetailForm();
      getPresenter().doUpdate(person);
    });

    revertButton.addEventListener("click", (e) -> {
      getPresenter().doRevert();
    });
  }

  public void createView() {
    panel = (HTMLDivElement) document.createElement("div");

    HTMLDivElement detailPanel = (HTMLDivElement) document.createElement("div");
    detailPanel.className = "detailPanel";
    panel.appendChild(detailPanel);

    HTMLDivElement headline = (HTMLDivElement) document.createElement("div");
    headline.innerHTML = "Details";
    UiUtils.setUpHeadline(headline);
    detailPanel.appendChild(headline);

    detailFirstName = new TextField("Firstname");
    detailPanel.appendChild(detailFirstName.getElement());

    detailName = new TextField("Name");
    detailPanel.appendChild(detailName.getElement());

    detailStreet = new TextField("Street");
    detailPanel.appendChild(detailStreet.getElement());

    detailZip = new TextField("ZIP");
    detailPanel.appendChild(detailZip.getElement());

    detailCity = new TextField("City");
    detailPanel.appendChild(detailCity.getElement());

    HTMLDivElement buttonBar = (HTMLDivElement) document.createElement("div");
    buttonBar.style.cssFloat = "left";
    buttonBar.style.textAlign = "right";
    buttonBar.style.width = CSSProperties.WidthUnionType.of("100%");
    detailPanel.appendChild(buttonBar);

    saveButton = (HTMLButtonElement) document.createElement("button");
    saveButton.textContent = "Save";
    UiUtils.setUButton(saveButton);
    buttonBar.appendChild(saveButton);

    revertButton = (HTMLButtonElement) document.createElement("button");
    revertButton.textContent = "Revert";
    UiUtils.setUButton(revertButton);
    buttonBar.appendChild(revertButton);
  }

  private void updateDetailForm() {
    person.setFirstName(detailFirstName.getText());
    person.setName(detailName.getText());
    person.getAddress().setStreet(detailStreet.getText());
    person.getAddress().setZip(detailZip.getText());
    person.getAddress().setCity(detailCity.getText());
  }
  
  private void setDetailForm() {
    if (person != null) {
      detailFirstName.setText(person.getFirstName());
      detailName.setText(person.getName());
      detailStreet.setText(person.getAddress().getStreet());
      detailZip.setText(person.getAddress().getZip());
      detailCity.setText(person.getAddress().getCity());
    }
  }

  @Override
  public Element asElement() {
    return panel;
  }
}
