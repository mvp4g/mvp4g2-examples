package de.gishmo.gwt.example.mvp4g2.springboot.client.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

public class UiUtils {

  public static void setUButton(HTMLButtonElement buttonElement) {
    buttonElement.style.width = CSSProperties.WidthUnionType.of("112px");
//    buttonElement.style.height = CSSProperties.HeightUnionType.of("36px");
//    buttonElement.style.backgroundColor = "lightgray";
//    buttonElement.style.color = "black";
//    buttonElement.style.fontWeight = "bold";
//    buttonElement.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
//    buttonElement.style.borderTopLeftRadius = CSSProperties.BorderTopLeftRadiusUnionType.of("12px");
//    buttonElement.style.borderBottomRightRadius = CSSProperties.BorderBottomRightRadiusUnionType.of("12px");
//    buttonElement.style.border = "2px solid darkgrey";
    buttonElement.style.margin = CSSProperties.MarginUnionType.of("6px 12px 6px 12px");
  }

  public static void setUpNavigationButton(HTMLButtonElement buttonElement) {
    buttonElement.style.width = CSSProperties.WidthUnionType.of("188px");
    buttonElement.style.height = CSSProperties.HeightUnionType.of("36px");
    buttonElement.style.backgroundColor = "lightgray";
    buttonElement.style.color = "black";
    buttonElement.style.fontWeight = "bold";
    buttonElement.style.fontSize = CSSProperties.FontSizeUnionType.of("14px");
    buttonElement.style.borderTopLeftRadius = CSSProperties.BorderTopLeftRadiusUnionType.of("12px");
    buttonElement.style.borderBottomRightRadius = CSSProperties.BorderBottomRightRadiusUnionType.of("12px");
    buttonElement.style.border = "2px solid darkgrey";
    buttonElement.style.margin = CSSProperties.MarginUnionType.of("12px");
  }

  public static void setUpHeadline(HTMLDivElement headlineElement) {
    headlineElement.style.fontFamily = "arial, sans-serif";
    headlineElement.style.fontWeight = "bold";
    headlineElement.style.color = "#4200fe";
    headlineElement.style.fontSize = CSSProperties.FontSizeUnionType.of("24px");
    headlineElement.style.margin = CSSProperties.MarginUnionType.of("12px");
  }

}
