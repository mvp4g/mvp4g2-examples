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

package de.gishmo.gwt.example.mvp4g2.mail.client.model;

import com.google.gwt.core.client.GWT;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailService;
import de.gishmo.gwt.example.mvp4g2.mail.client.service.MailServiceAsync;

/**
 * we will use this class as 'client-sided session container'
 */
public class ClientContext {

  private static ClientContext    instance;
  /* Service */
  private        MailServiceAsync mailService;

  private ClientContext() {
    mailService = GWT.create(MailService.class);
  }

  public static ClientContext get() {
    if (instance == null) {
      instance = new ClientContext();
    }
    return instance;
  }

  /**
   * our email service ...
   *
   * @return instace of the email service
   */
  public MailServiceAsync getMailService() {
    return mailService;
  }
}
