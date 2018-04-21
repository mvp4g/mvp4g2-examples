package tld.domain.project.application.gxtmvp4g2application.client.ui.search;

import com.github.mvp4g.mvp4g2.core.ui.IsLazyReverseView;
import com.google.gwt.user.client.ui.Widget;

/**
 * Copyright (C) 2018 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public interface ISearchView extends IsLazyReverseView<ISearchView.Presenter> {
  /**
   * mvp4g2 does not know Widget-, Element- or any other GWT specific class. So, the
   * presenter have to manage the widget by themselves. The method will
   * enable the presenter to get the view. (In our case it is a
   * GWT widget)
   *
   * @return The shell widget
   */
  Widget asWidget();

  interface Presenter {
  }
}
