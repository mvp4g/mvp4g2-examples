package de.gishmo.gwt.example.mvp4g2.springboot.client.ui.detail;

import de.gishmo.gwt.example.mvp4g2.springboot.client.data.model.dto.Person;
import de.gishmo.gwt.example.mvp4g2.springboot.client.widgets.TextField;
import de.gishmo.gwt.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;


public class DetailView
  extends LazyReverseView<IDetailView.Presenter>
  implements IDetailView {

  private HTMLDivElement container;

  private TextField detailFirstName;
  private TextField detailName;
  private TextField detailStreet;
  private TextField detailZip;
  private TextField detailCity;

  private HTMLButtonElement saveButton;
  private HTMLButtonElement revertButton;

  private Person person;

  public DetailView() {
    super();
  }

  public void createView() {
    container = div().add(div().style("width: 100%;")
                               .add(div().css("headline")
                                         .textContent("Details"))
                               .add(detailFirstName = new TextField("Firstname"))
                               .add(detailName = new TextField("Name"))
                               .add(detailStreet = new TextField("Street"))
                               .add(detailZip = new TextField("Zip"))
                               .add(detailCity = new TextField("City"))
                               .add(div().css("buttonBar")
                                         .add(button().css("button")
                                                      .textContent("Save")
                                                      .on(click,
                                                          event -> {
                                                            updateDetailForm();
                                                            getPresenter().doUpdate(person);
                                                          }))
                                         .add(button().css("button")
                                                      .textContent("Revert")
                                                      .on(click,
                                                          event -> {
                                                            getPresenter().doRevert();
                                                          }))))
                     .asElement();
  }

  private void updateDetailForm() {
    person.setFirstName(detailFirstName.getText());
    person.setName(detailName.getText());
    person.getAddress()
          .setStreet(detailStreet.getText());
    person.getAddress()
          .setZip(detailZip.getText());
    person.getAddress()
          .setCity(detailCity.getText());
  }

  @Override
  public Element asElement() {
    return container;
  }

  @Override
  public boolean isDirty() {
    boolean notDirty = (person.getFirstName()
                              .equals(detailFirstName.getText())
                       ) &&
                       (person.getName()
                              .equals(detailName.getText())
                       ) &&
                       (person.getAddress()
                              .getStreet()
                              .equals(detailStreet.getText())
                       ) &&
                       (person.getAddress()
                              .getZip()
                              .equals(detailZip.getText())
                       ) &&
                       (person.getAddress()
                              .getCity()
                              .equals(detailCity.getText())
                       );
    return !notDirty;
  }

  @Override
  public void setUpData(Person person) {
    this.person = person;
    setDetailForm();
  }

  private void setDetailForm() {
    if (person != null) {
      detailFirstName.setText(person.getFirstName());
      detailName.setText(person.getName());
      detailStreet.setText(person.getAddress()
                                 .getStreet());
      detailZip.setText(person.getAddress()
                              .getZip());
      detailCity.setText(person.getAddress()
                               .getCity());
    }
  }
}
