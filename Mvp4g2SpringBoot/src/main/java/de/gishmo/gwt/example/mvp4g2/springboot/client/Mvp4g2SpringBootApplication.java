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

import com.github.mvp4g.mvp4g2.core.application.IsApplication;
import com.github.mvp4g.mvp4g2.core.application.annotation.Application;

/**
 * Implemantation of the MailApplicaiton class.
 * <p>
 * <p>Use the @IsApplication annotation to perform configuration informations.</p>
 * <p>In this case we use the 'Mvp4g2SpringBootEventBus' class
 * as event bus of our application and 'Mvp4g2SPringBootLoader'
 * as loader!</p>
 * <p>Please keep in mind, the services are simulated inside the client (because this is not part of the
 * framework). You can use any technique to call the serner!</p>
 * <p>Inside the view, we will use Elemento to setup view.</p>
 */
@Application(eventBus = Mvp4g2SpringBootEventBus.class,
             loader = Mvp4g2SPringBootLoader.class,
             historyOnStart = true)
interface Mvp4g2SprinbgBootApplication
  extends IsApplication {
}
