package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets;

import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;

import static elemental2.dom.DomGlobal.document;

public class TextField {

  private HTMLDivElement widgetContainer;
  private HTMLDivElement   widgetPanel;
  private HTMLDivElement   panel;
  private HTMLDivElement   label;
  private HTMLDivElement widgetContainerTextBox;
  private HTMLInputElement textBox;

  public TextField() {
    this(null);
  }


  public TextField(String label) {
    createWidget();

    setLabel(label);
  }

  private void createWidget() {
    widgetContainer = (HTMLDivElement) document.createElement("div");
    widgetContainer.className = "widgetContainerTextBox";

    widgetPanel = (HTMLDivElement) document.createElement("div");
    widgetPanel.className = "widgetPanelTextBox";
    widgetContainer.appendChild(widgetPanel);

    panel = (HTMLDivElement) document.createElement("div");
    panel.className = "panelTextBox";
    widgetPanel.appendChild(panel);

    label = (HTMLDivElement) document.createElement("div");
    label.className = "labelTextBox";
    panel.appendChild(label);

    widgetContainerTextBox = (HTMLDivElement) document.createElement("div");
    widgetContainerTextBox.className = "widgetContainerTextBoxTextBox";
    panel.appendChild(widgetContainerTextBox);

    textBox = (HTMLInputElement) document.createElement("input",
                                                        "text");
    textBox.className = "textBoxTextBox";
    widgetContainerTextBox.appendChild(textBox);
  }

  private void forceLayout() {
    Js.debugger();
    if (widgetPanel.parentNode != null) {
      Element parent = (Element) widgetPanel.parentNode;
      if (parent != null) {
        double parentWidth = parent.clientWidth;

//        label.style.width = CSSProperties.WidthUnionType.of("");
//        textBox.style.width = CSSProperties.WidthUnionType.of(parentWidth - 48);
//        label.style.width = CSSProperties.WidthUnionType.of(parentWidth - 48);
//        textBox.style.width = CSSProperties.WidthUnionType.of(parentWidth - 48);
      }
    }
  }

  public Element getElement() {
    return this.widgetContainer;
  }

  public String getLabel() {
    return label.innerHTML.toString();
  }

  public void setLabel(String label) {
    if (label != null && label.length() > 0) {
      this.label.innerHTML = label;
      this.label.style.visibility = "visible";
      widgetPanel.style.height = CSSProperties.HeightUnionType.of(68);
    } else {
      this.label.innerHTML = label;
      this.label.style.visibility = "hidden";
      widgetPanel.style.height = CSSProperties.HeightUnionType.of(42);
    }
  }

  public String getText() {
    return textBox.value;
  }

  public void setText(String text) {
    this.textBox.value = text;
  }

}
