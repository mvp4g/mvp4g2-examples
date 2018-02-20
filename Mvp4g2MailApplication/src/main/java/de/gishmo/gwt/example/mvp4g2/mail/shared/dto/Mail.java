/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.gishmo.gwt.example.mvp4g2.mail.shared.dto;

import de.gishmo.gwt.example.mvp4g2.mail.shared.GUID;

/**
 * A simple structure containing the basic components of an email.
 */
public final class Mail {

  /* uniques id */
  private final String id = GUID.get();
  /* The sender's name */
  private String sender;
  /* The sender's email */
  private String email;
  /* The email subject line */
  private String subject;
  /* The email's HTML body */
  private String body;
  /* Read flag */
  private boolean read;

  public Mail() {
  }

  public Mail(String sender,
              String email,
              String subject,
              String body) {
    this.sender = sender;
    this.email = email;
    this.subject = subject;
    this.body = body;
    this.read = read;
  }

  public String getId() {
    return id;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }
}
