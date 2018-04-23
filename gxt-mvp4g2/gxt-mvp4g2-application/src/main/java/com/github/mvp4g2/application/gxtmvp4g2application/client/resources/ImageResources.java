package com.github.mvp4g2.application.gxtmvp4g2application.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageResources
    extends ClientBundle {

  ImageResources IMAGES = GWT.create(ImageResources.class);

  @Source("iconNew.png")
  ImageResource iconNew();

  @Source("iconEdit.png")
  ImageResource iconEdit();

}
