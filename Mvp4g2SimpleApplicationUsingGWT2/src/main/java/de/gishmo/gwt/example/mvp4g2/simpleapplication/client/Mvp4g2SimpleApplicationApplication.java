/*
 * Copyright (C) 2016 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package de.gishmo.gwt.example.mvp4g2.simpleapplication.client;

import de.gishmo.gwt.mvp4g2.core.application.IsApplication;
import de.gishmo.gwt.mvp4g2.core.application.annotation.Application;

/**
 * Implemantation of the MailApplicaiton class.
 * <p>
 * <p>Use the @IsApplication annotation to perform configuration informations.</p>
 */
@Application(eventBus = Mvp4g2SimpleApplicationEventBus.class,
             loader = Mvp4g2SimpleApplicationLoader.class)
interface Mvp4g2SimpleApplicationApplication
  extends IsApplication {
}
