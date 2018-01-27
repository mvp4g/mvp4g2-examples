package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.jboss.gwt.elemento.core.InputType;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.EventType.blur;
import static org.jboss.gwt.elemento.core.EventType.focus;

/**
 * The TextField class is the text widget used by the application.
 */
public class TextField
  implements IsElement<HTMLElement> {

  private HTMLElement      container;
  private HTMLDivElement   label;
  private HTMLInputElement textBox;

  public TextField() {
    this(null);
  }

  public TextField(String label) {
    createWidget();

    setLabel(label);
  }

  private void createWidget() {
    container = div().css("textFieldWidgetContainer",
                          "textFieldTwoRow")
                     .add(label = div().css("textFieldLabel",
                                            "visible")
                                       .asElement())
                     .add(div().css("textFieldDivElement")
                               .add(textBox = input(InputType.text).css("textFieldTextBox")
                                                                   .on(focus,
                                                                       event -> textBox.classList.add("yellow"))
                                                                   .on(blur,
                                                                       event -> textBox.classList.remove("yellow"))
                                                                   .asElement()))
                     .asElement();
  }

  public String getLabel() {
    return label.innerHTML.toString();
  }

  public void setLabel(String label) {
    if (label != null && label.length() > 0) {
      this.label.innerHTML = label;
      this.label.classList.add("visible");
      this.label.classList.remove("hidden");
      this.container.classList.remove("textFieldOneRow");
      this.container.classList.add("textFieldTwoRow");
    } else {
      this.label.innerHTML = "";
      this.label.classList.add("hidden");
      this.label.classList.remove("visible");
      this.container.classList.remove("textFieldTwoRow");
      this.container.classList.add("textFieldOneRow");
    }
  }

  public String getText() {
    return textBox.value;
  }

  public void setText(String text) {
    this.textBox.value = text;
  }

  @Override
  public HTMLElement asElement() {
    return this.container;
  }
}
