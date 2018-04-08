/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package de.gishmo.gwt.example.mvp4g2.springboot.client;

import com.github.mvp4g.mvp4g2.core.application.IsApplicationLoader;
import elemental2.dom.DomGlobal;

/**
 * A application loader of the Mvp4g2MailApplication
 */
public class Mvp4g2SPringBootLoader
  implements IsApplicationLoader {

  /**
   * The laoder of the applciation.
   * <p>
   * Will be executed at the start of the application
   * and before the first event is executed.
   *
   * @param finishLoadCommand has to be called after the application has finieshed loading
   */
  @Override
  public void load(FinishLoadCommand finishLoadCommand) {
    DomGlobal.window.alert("Do Loading ... ");
    finishLoadCommand.finishLoading();
  }
}
