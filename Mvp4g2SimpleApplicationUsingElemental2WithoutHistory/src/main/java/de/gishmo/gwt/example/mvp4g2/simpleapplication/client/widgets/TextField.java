package de.gishmo.gwt.example.mvp4g2.simpleapplication.client.widgets;

import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLInputElement;
import jsinterop.base.Js;

import static elemental2.dom.DomGlobal.document;

public class TextField {

  private HTMLDivElement   widgetContainer;
  private HTMLDivElement   widgetPanel;
  private HTMLDivElement   panel;
  private HTMLDivElement   label;
  private HTMLDivElement   widgetContainerTextBox;
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
    widgetContainer.style.height = CSSProperties.HeightUnionType.of("72px");
    widgetContainer.style.margin = CSSProperties.MarginUnionType.of("12px");
    widgetContainer.style.border = "1px solid #4200fe";
    widgetContainer.style.borderRadius = CSSProperties.BorderRadiusUnionType.of("6px");
    widgetContainer.style.backgroundColor = "#d3f4fa";
    panel = (HTMLDivElement) document.createElement("div");

    label = (HTMLDivElement) document.createElement("div");
    label.style.margin = CSSProperties.MarginUnionType.of("6px 4px 2px 12px");
    label.style.fontFamily = "arial, sans-serif";
    label.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    label.style.fontWeight = "bold";
    label.style.color = "#4200fe";
    widgetContainer.appendChild(label);

    HTMLDivElement textBoxDivElement = (HTMLDivElement) document.createElement("div");
    textBoxDivElement.style.display = "flex";
    textBoxDivElement.style.width = CSSProperties.WidthUnionType.of("100%");
    widgetContainer.appendChild(textBoxDivElement);

    textBox = (HTMLInputElement) document.createElement("input",
                                                        "text");
    textBox.style.fontFamily = "arial, sans-serif";
    textBox.style.margin = CSSProperties.MarginUnionType.of("6px 12px 2px 12px");
    textBox.style.padding = CSSProperties.PaddingUnionType.of("6px");
    textBox.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    textBox.style.fontWeight = "normal";
    textBox.style.color = "#4200fe";
    textBox.style.flex = "1 ";
    textBox.style.width = CSSProperties.WidthUnionType.of("100%");
    textBoxDivElement.appendChild(textBox);
  }

  private void forceLayout() {
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
      widgetContainer.style.height = CSSProperties.HeightUnionType.of(68);
    } else {
      this.label.innerHTML = label;
      this.label.style.visibility = "hidden";
      widgetContainer.style.height = CSSProperties.HeightUnionType.of(42);
    }
  }

  public String getText() {
    return textBox.value;
  }

  public void setText(String text) {
    this.textBox.value = text;
  }

}
