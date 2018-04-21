package com.github.mvp4g2.application.gxtmvp4g2application.client.ui.header;

import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import com.github.mvp4g2.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;

/**
 * Copyright (C) 2018 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Presenter(
  viewClass = HeaderView.class,
  viewInterface = IHeaderView.class
)
public class HeaderPresenter
  extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, IHeaderView>
  implements IHeaderView.Presenter {
  public HeaderPresenter() {
  }

  @Override
  public void bind() {
    eventBus.setHeader(view.asWidget());
  }
}
