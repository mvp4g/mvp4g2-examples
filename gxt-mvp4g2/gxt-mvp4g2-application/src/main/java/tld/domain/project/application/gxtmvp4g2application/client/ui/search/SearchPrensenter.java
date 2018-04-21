package tld.domain.project.application.gxtmvp4g2application.client.ui.search;

import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import tld.domain.project.application.gxtmvp4g2application.client.GxtMvp4g2ApplicationEventBus;

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
  viewClass = SearchView.class,
  viewInterface = ISearchView.class
)
public class SearchPrensenter
  extends AbstractPresenter<GxtMvp4g2ApplicationEventBus, ISearchView>
  implements ISearchView.Presenter {

  public SearchPrensenter() {
  }

  @Override
  public void onBeforeEvent(String eventName) {
    // This method will be call in case the presenter will handle a event and before the event handling
  }

  @EventHandler
  public void onGotoSearch(String searchName,
                           String searchCity) {
    eventBus.setContent(view.asWidget());
  }

  @EventHandler
  public void onInitHistory() {
    eventBus.gotoSearch();
  }
}
